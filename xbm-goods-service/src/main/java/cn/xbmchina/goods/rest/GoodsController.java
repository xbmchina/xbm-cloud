package cn.xbmchina.goods.rest;

import cn.xbmchina.goods.entity.Goods;
import cn.xbmchina.goods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodService goodService;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Goods findById(@PathVariable Long id){
        return goodService.findById(id);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestBody Goods goods){
         goodService.save(goods);
         return "success";
    }
}
