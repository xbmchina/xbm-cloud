package cn.xbmchina.order.service.hystrix;

import cn.xbmchina.order.model.vo.AccountVo;
import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.AccountService;
import cn.xbmchina.order.service.GoodsService;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceFallback implements AccountService {

    @Override
    public AccountVo findById(Long id) {
        System.out.println("AccountServiceFallback#findById");
        return null;
    }

    @Override
    public String updateAccount(AccountVo accountVo) {
        System.out.println("AccountServiceFallback#updateAccount");
        return null;
    }

    @Override
    public AccountVo findAccountVo(AccountVo accountVo) {
        System.out.println("AccountServiceFallback#findAccountVo");
        return null;
    }
}
