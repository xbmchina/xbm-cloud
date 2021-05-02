package cn.xbmchina.account.service;

import cn.xbmchina.account.model.vo.AccountVo;

public interface AccountService {

    AccountVo findAccountById(Long id);

    void save(AccountVo accountVo);

    AccountVo findAccountVo(AccountVo accountVo);
}
