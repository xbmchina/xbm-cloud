## Hystrix熔断器

官方文档：

https://github.com/Netflix/hystrix

https://github.com/Netflix/Hystrix/wiki

工作原理：

https://github.com/Netflix/Hystrix/wiki/How-it-Works

## Hystrix与feign集成

1、添加依赖

```xml
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
  </dependency>
```

2、开启hystrix配置

```yaml
feign:
  hystrix:
    enabled: true
```

3、添加fallback

```java
@FeignClient(name ="service-goods",fallback = GoodsServiceFallback.class)
public interface GoodsService {

    @RequestMapping("/goods/{id}")
    GoodsVo findById(@RequestParam(value = "id")Long id);

    @RequestMapping(value = "/goods/save",method = RequestMethod.POST)
    public String save(@RequestBody GoodsVo goods);
}
```


## Hystrix常用配置

1、官网关键配置：

https://github.com/Netflix/Hystrix/wiki/Configuration

优秀博客：
https://www.cnblogs.com/throwable/p/11961016.html


2、部分参数：

* hystrix.command.default.execution.isolation.strategy：隔离策略，默认是Thread, 可选Thread，Semaphore
* hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds 命令执行超时时间，默认1000ms。
* hystrix.command.default.execution.timeout.enabled：执行是否启用超时，默认启用true。
* hystrix.command.default.execution.isolation.thread.interruptOnTimeout：发生超时是是否中断，默认true。
* hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests：最大并发请求上限




































