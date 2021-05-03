package cn.xbmchina.account.rest;

import cn.xbmchina.account.model.vo.AccountVo;
import cn.xbmchina.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AccountVo findById(@PathVariable Long id){
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/findAccountVo",method = RequestMethod.POST)
    public AccountVo findAccountVo(@RequestBody AccountVo accountVo){
        return accountService.findAccountVo(accountVo);
    }

    @RequestMapping(value = "/updateAccount",method = RequestMethod.POST)
    public String updateAccount(@RequestBody AccountVo accountVo){
        accountService.save(accountVo);
         return "success";
    }
}