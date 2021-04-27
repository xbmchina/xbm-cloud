package cn.xbmchina.order.service.hystrix;

import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.GoodsService;
import org.springframework.stereotype.Component;

@Component
public class GoodsServiceFallback implements GoodsService {
    @Override
    public GoodsVo findById(Long id) {
        return null;
    }
}
