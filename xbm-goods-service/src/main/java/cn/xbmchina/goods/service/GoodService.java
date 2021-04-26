package cn.xbmchina.goods.service;

import cn.xbmchina.goods.entity.Goods;

public interface GoodService {

    Goods findById(Long id);

    void save(Goods goods);

    void updateById(Goods goods);

    void delete(Long id);
}
