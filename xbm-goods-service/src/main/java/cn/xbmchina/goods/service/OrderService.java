package cn.xbmchina.goods.service;

import cn.xbmchina.goods.model.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name ="service-order")
public interface OrderService {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public OrderVo findById(@PathVariable Long id);
}
