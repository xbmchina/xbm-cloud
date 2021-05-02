package cn.xbmchina.order.service;

import cn.xbmchina.order.model.vo.AccountVo;
import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.hystrix.AccountServiceFallback;
import cn.xbmchina.order.service.hystrix.GoodsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="service-account",fallback = AccountServiceFallback.class)
public interface AccountService {

    @RequestMapping(value = "/account/{id}",method = RequestMethod.GET)
    public AccountVo findById(@PathVariable Long id);

    @RequestMapping(value = "/account/updateAccount",method = RequestMethod.POST)
    public String updateAccount(@RequestBody AccountVo accountVo);

    @RequestMapping(value = "/account/findAccountVo",method = RequestMethod.POST)
    public AccountVo findAccountVo(@RequestBody AccountVo accountVo);
}
