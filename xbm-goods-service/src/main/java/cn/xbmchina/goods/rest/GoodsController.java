package cn.xbmchina.goods.rest;

import cn.xbmchina.goods.entity.Goods;
import cn.xbmchina.goods.model.vo.OrderVo;
import cn.xbmchina.goods.service.GoodService;
import cn.xbmchina.goods.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@Api(value="商品控制类",tags = "商品控制类",description = "商品控制类")
public class GoodsController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private OrderService orderService;



    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Goods findById(@PathVariable Long id){
        return goodService.findById(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody Goods goods){
         goodService.save(goods);
         return "success";
    }

    @RequestMapping(value = "/findOrderById/{id}",method = RequestMethod.GET)
    public OrderVo findOrderById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @ApiOperation(value="testgw",notes="testgw",response=String.class)
    @RequestMapping(value = "/testgw",method = RequestMethod.GET)
    public String testGw(){
        return "goods===success";
    }
}
