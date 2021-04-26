package cn.xbmchina.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_order")
public class Order {

    @Id
    private Long id;
    private Long goodId;
    private String status;
    private Integer price;
    private String orderDesc;
    private String username;

}
