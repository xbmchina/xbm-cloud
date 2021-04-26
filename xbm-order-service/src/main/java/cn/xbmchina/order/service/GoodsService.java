package cn.xbmchina.order.service;

import cn.xbmchina.order.model.vo.GoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="service-goods")
public interface GoodsService {

    @RequestMapping("/goods/{id}")
    GoodsVo findById(@RequestParam(value = "id")Long id);
}
