package cn.xbmchina.goods.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_goods")
public class Goods {

    @Id
    private Long id;
    private String name;
    private String status;
    private Integer price;
    private String goodDesc;
    private String caption;
    private Integer stock;

}
