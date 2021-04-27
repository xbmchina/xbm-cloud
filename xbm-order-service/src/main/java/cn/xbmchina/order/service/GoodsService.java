package cn.xbmchina.order.service;

import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.hystrix.GoodsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="service-goods",fallback = GoodsServiceFallback.class)
public interface GoodsService {

    @RequestMapping("/goods/{id}")
    GoodsVo findById(@RequestParam(value = "id")Long id);
}
