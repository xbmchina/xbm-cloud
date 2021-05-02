package cn.xbmchina.account.dao;

import cn.xbmchina.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountDao extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {

    @Modifying
    @Query(value = "update tb_account set use_total =use_total+?1 where pay_total>use_total and id = ?2 ", nativeQuery = true)
    void updateAccountUseTotal(Integer useTotal,Long id);

    Account findAccountByName(String name);
}
