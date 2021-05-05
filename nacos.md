
## 注册中心nacos
官网地址:https://nacos.io/zh-cn/docs/quick-start.html

### 连接nacos注册配置中心配置示例：

1、pom.xml依赖文件

```xml
 <!--nacos注册中心客户端-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <!--nacos配置中心客户端-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
```

2、bootstrap.yml配置

```yaml
spring:
  application:
    name: service-gateway
  cloud:
    nacos:
      server-addr: 127.0.0.1:8848
      config:
        username: nacos
        password: nacos
        enabled: true
        encode: UTF-8
        timeout: 60000
        namespace: xbm-cloud
      discovery:
        enabled: true
        heart-beat-interval: 60000
        namespace: xbm-cloud
```

3、启动类中添加@EnableDiscoveryClient注解

### 监听nacos某配置文件事件：

核心代码NacosDynamicRouteService,更多
详情可参考xbm-gateway模块

```java
@Component
@Slf4j
public class NacosDynamicRouteService {

    private static final String DATA_ID = "router.json";
    private static final String DEFAULT_GROUP = "DEFAULT_GROUP";
    private static final Integer TIMEOUT = 60000;

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
       log.info("config="+config);
    }
}
```

### 常见问题解决办法

1、疯狂打印日志

https://lixuekai.blog.csdn.net/article/details/110189918

```yaml
# 3、在任意格式的配置文件中将该包路径的日志设置为 ERROR 或者 WARN 级别即可
# Nacos 注册中心客户端心跳日志禁用 get changedGroupKeys:[] 刷屏
logging:
  level:
    com.alibaba.nacos.client.config.impl: WARN
  
# 4、如果是 Spring Cloud Gateway 则需要配置为
logging:
  level:
    com.alibaba.nacos.client.*: WARN
```

2、使用外部Tomcat时无法找到服务

https://blog.csdn.net/u013719791/article/details/105842449

```java
/**
 * 让外部tomcat中的程序也能向nacos注册
 * @author shichenyang
 */
@Configuration
public class NacosConfig implements ApplicationRunner {

    @Autowired(required = false)
    private NacosAutoServiceRegistration registration;

    @Value("${server.port}")
    Integer port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (registration != null && port != null) {
            Integer tomcatPort = port;
            try {
                tomcatPort = new Integer(getTomcatPort());
            } catch (Exception e) {
                e.printStackTrace();
            }

            registration.setPort(tomcatPort);
            registration.start();
        }
    }
    /**
     * 获取外部tomcat端口
     */
    public String getTomcatPort() throws Exception {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"), Query.match(Query.attr("protocol"), Query.value("org.apache.coyote.http11.Http11AprProtocol")));
        String port = objectNames.iterator().next().getKeyProperty("port");
        return port;
    }

}
```

