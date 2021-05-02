package cn.xbmchina.account.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_account")
public class Account {
    @Id
    private Long id;
    private String name;
    private String phone;
    private Integer payTotal;
    private Integer useTotal;

}
