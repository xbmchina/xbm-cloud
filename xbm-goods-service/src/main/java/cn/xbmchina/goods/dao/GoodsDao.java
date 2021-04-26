package cn.xbmchina.goods.dao;

import cn.xbmchina.goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsDao extends JpaRepository<Goods,Long>, JpaSpecificationExecutor<Goods> {
}
