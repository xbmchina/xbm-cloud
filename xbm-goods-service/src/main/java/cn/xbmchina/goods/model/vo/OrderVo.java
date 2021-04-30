package cn.xbmchina.goods.model.vo;

import lombok.Data;


@Data
public class OrderVo {

    private Long id;
    private Long goodId;
    private String status;
    private Integer price;
    private String orderDesc;
    private String username;

}
