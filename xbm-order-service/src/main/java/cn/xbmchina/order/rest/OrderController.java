package cn.xbmchina.order.rest;

import cn.xbmchina.order.entity.Order;
import cn.xbmchina.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Order findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody Order order){
        orderService.save(order);
         return "success";
    }
}
