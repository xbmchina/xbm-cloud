package cn.xbmchina.order.service;


import cn.xbmchina.order.entity.Order;

public interface OrderService {

    Order findById(Long id);

    void save(Order order);

    void updateById(Order order);

    void delete(Long id);
}
