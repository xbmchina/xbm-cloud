package cn.xbmchina.order.model.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class GoodsVo {

    @Id
    private Long id;
    private String name;
    private String status;
    private Integer price;
    private String goodDesc;
    private String caption;
    private Integer stock;

}
