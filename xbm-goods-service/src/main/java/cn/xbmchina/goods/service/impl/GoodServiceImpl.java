package cn.xbmchina.goods.service.impl;

import cn.xbmchina.goods.dao.GoodsDao;
import cn.xbmchina.goods.entity.Goods;
import cn.xbmchina.goods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Goods findById(Long id) {
        Optional<Goods> goods = goodsDao.findById(id);
        return Optional.ofNullable(goods.get()).orElse(new Goods());
    }

    @Override
    public void save(Goods goods) {
        goodsDao.save(goods);
    }

    @Override
    public void updateById(Goods goods) {
        goodsDao.save(goods);
    }

    @Override
    public void delete(Long id) {
        goodsDao.deleteById(id);
    }
}
