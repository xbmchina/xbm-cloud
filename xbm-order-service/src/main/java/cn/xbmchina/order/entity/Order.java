package cn.xbmchina.order.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long goodId;
    private String status;
    private Integer price;
    private String orderDesc;
    private String userName;

}
