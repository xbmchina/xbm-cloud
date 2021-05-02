package cn.xbmchina.account.model.vo;

import lombok.Data;

@Data
public class AccountVo {
    private Long id;
    private String name;
    private String phone;
    private Integer payTotal;
    private Integer useTotal;
}
