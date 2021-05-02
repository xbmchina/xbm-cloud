package cn.xbmchina.order.service.impl;

import cn.xbmchina.order.dao.OrderDao;
import cn.xbmchina.order.entity.Order;
import cn.xbmchina.order.model.vo.AccountVo;
import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.AccountService;
import cn.xbmchina.order.service.GoodsService;
import cn.xbmchina.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AccountService accountService;

    @Override
    public Order findById(Long id) {
        Optional<Order> goods = orderDao.findById(id);
        return Optional.ofNullable(goods.get()).orElse(new Order());
    }

    @Override
    public void save(Order order) {

        GoodsVo goodsVo = goodsService.findById(order.getGoodId());
        goodsVo.setStock(goodsVo.getStock()-1);
        goodsService.save(goodsVo);

        AccountVo accountVo = new AccountVo();
        accountVo.setName(order.getUserName());
        accountVo = accountService.findAccountVo(accountVo);
        accountVo.setUseTotal(accountVo.getUseTotal()+order.getPrice());
        accountService.updateAccount(accountVo);
        int i =10/0;
        orderDao.save(order);

    }

    @Override
    public void updateById(Order order) {
        orderDao.save(order);
    }

    @Override
    public void delete(Long id) {
        orderDao.deleteById(id);
    }
}
