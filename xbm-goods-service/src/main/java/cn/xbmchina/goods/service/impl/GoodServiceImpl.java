package cn.xbmchina.goods.service.impl;

import cn.xbmchina.goods.dao.GoodsDao;
import cn.xbmchina.goods.entity.Goods;
import cn.xbmchina.goods.model.vo.ResultModel;
import cn.xbmchina.goods.service.GoodService;
//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
//    @SentinelResource(value = "findById", blockHandler = "exceptionHandler",fallback = "fallbackHandler")
    public Goods findById(Long id) {
        Optional<Goods> goods = goodsDao.findById(id);
        return Optional.ofNullable(goods.get()).orElse(new Goods());
    }

//    public ResultModel exceptionHandler(BlockException ex) {
//        ex.printStackTrace();
//        return ResultModel.error("请求过于频繁");
//    }
//
//    public ResultModel fallbackHandler(Exception ex) {
//        ex.printStackTrace();
//        return ResultModel.error("fallbackHandler");
//    }

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
