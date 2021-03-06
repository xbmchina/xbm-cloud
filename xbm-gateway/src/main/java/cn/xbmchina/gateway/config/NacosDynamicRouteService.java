package cn.xbmchina.gateway.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.alibaba.nacos.api.exception.NacosException;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * nacos配置动态更新gateway路由
 */
@Component
@Slf4j
public class NacosDynamicRouteService implements ApplicationEventPublisherAware, ApplicationRunner {

    private static final String DATA_ID = "router.json";
    private static final String DEFAULT_GROUP = "DEFAULT_GROUP";
    private static final Integer TIMEOUT = 60000;
    private static final List<String> ROUTE_LIST = new ArrayList<>();

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    public void dynamicRouteByNacosListener() {
        try {
            ConfigService configService = nacosConfigManager.getConfigService();
            String initConfig = configService.getConfigAndSignListener(DATA_ID, DEFAULT_GROUP,
                    TIMEOUT, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String config) {
                    refreshRouter(config);
                }
            });
            refreshRouter(initConfig);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    private void refreshRouter(String config) {
        try {
            log.info("config="+config);
            clearRoute();
            try {
                if (StringUtil.isNullOrEmpty(config)) {//配置被删除
                    return;
                }
                List<RouteDefinition> gatewayRouteDefinitions = JSONObject.parseArray(config, RouteDefinition.class);
                for (RouteDefinition routeDefinition : gatewayRouteDefinitions) {
                    addRoute(routeDefinition);
                }
                publish();
            } catch (Exception e) {
                log.error("receiveConfigInfo error" + e);
            }
        } catch (Exception e) {
            log.error("dynamicRouteByNacosListener error" + e);
        }
    }

    private void clearRoute() {
        for (String id : ROUTE_LIST) {
            this.routeDefinitionWriter.delete(Mono.just(id)).subscribe();
        }
        ROUTE_LIST.clear();
    }

    private void addRoute(RouteDefinition definition) {
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            ROUTE_LIST.add(definition.getId());
        } catch (Exception e) {
            log.error("addRoute error" + e);
        }
    }

    private void publish() {
        this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this.routeDefinitionWriter));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dynamicRouteByNacosListener();
    }
}
