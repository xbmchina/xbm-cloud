package cn.xbmchina.order.rest;

import cn.xbmchina.order.entity.Order;
import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.GoodsService;
import cn.xbmchina.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api(value="订单控制类",tags = "订单控制类",description = "订单控制类")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Order findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @GlobalTransactional
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String save(){
        System.out.println("12s1df2asdf454445");
        Order order = new Order();
        order.setGoodId(1L);
        order.setOrderDesc("嘎嘎十多个");
        order.setUserName("xbm");
        order.setPrice(12);
        order.setStatus("已支付");
        orderService.save(order);
        System.out.println("success..........");
         return "success";
    }

    @RequestMapping(value = "/findGoods/{id}",method = RequestMethod.GET)
    public GoodsVo findGoods(@PathVariable Long id){
        return goodsService.findById(id);
    }



    @RequestMapping(value = "/testgw",method = RequestMethod.GET)
    public String testGw(){
        return "order===success";
    }
}
