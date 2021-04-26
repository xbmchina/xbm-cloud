package cn.xbmchina.order.rest;

import cn.xbmchina.order.entity.Order;
import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.GoodsService;
import cn.xbmchina.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Order findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody Order order){
        orderService.save(order);
         return "success";
    }

    @RequestMapping(value = "/findGoods/{id}",method = RequestMethod.GET)
    public GoodsVo findGoods(@PathVariable Long id){
        return goodsService.findById(id);
    }
}
