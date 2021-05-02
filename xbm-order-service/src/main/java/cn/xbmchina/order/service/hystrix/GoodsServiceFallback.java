package cn.xbmchina.order.service.hystrix;

import cn.xbmchina.order.model.vo.GoodsVo;
import cn.xbmchina.order.service.GoodsService;
import org.springframework.stereotype.Component;

@Component
public class GoodsServiceFallback implements GoodsService {
    @Override
    public GoodsVo findById(Long id) {
        System.out.println("GoodsServiceFallback#findById");
        return null;
    }

    @Override
    public String save(GoodsVo goods) {
        System.out.println("GoodsServiceFallback#save");
        return null;
    }
}
