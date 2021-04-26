package cn.xbmchina.order.service;


import cn.xbmchina.order.entity.Order;

public interface OrderService {

    Order findById(Long id);

    void save(Order goods);

    void updateById(Order goods);

    void delete(Long id);
}
