package cn.xbmchina.order.service.impl;

import cn.xbmchina.order.dao.OrderDao;
import cn.xbmchina.order.entity.Order;
import cn.xbmchina.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order findById(Long id) {
        Optional<Order> goods = orderDao.findById(id);
        return Optional.ofNullable(goods.get()).orElse(new Order());
    }

    @Override
    public void save(Order goods) {
        orderDao.save(goods);
    }

    @Override
    public void updateById(Order goods) {
        orderDao.save(goods);
    }

    @Override
    public void delete(Long id) {
        orderDao.deleteById(id);
    }
}
