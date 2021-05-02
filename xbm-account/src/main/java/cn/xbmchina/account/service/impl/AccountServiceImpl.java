package cn.xbmchina.account.service.impl;

import cn.xbmchina.account.dao.AccountDao;
import cn.xbmchina.account.entity.Account;
import cn.xbmchina.account.model.vo.AccountVo;
import cn.xbmchina.account.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public AccountVo findAccountById(Long id) {
        Account account = accountDao.findById(id).orElse(new Account());
        AccountVo accountVo = new AccountVo();
        BeanUtils.copyProperties(account, accountVo);
        return accountVo;
    }

    @Override
    public void save(AccountVo accountVo) {
        Account account = new Account();
        BeanUtils.copyProperties(accountVo,account);
        accountDao.save(account);
    }

    @Override
    public AccountVo findAccountVo(AccountVo accountVo) {
        Account account = accountDao.findAccountByName(accountVo.getName());
        BeanUtils.copyProperties(account,accountVo);
        return accountVo;
    }
}
