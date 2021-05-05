## Feign服务间调用

官方使用文档：

https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#spring-cloud-feign

主要配置介绍：

https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/appendix.html

### 简单使用

1、pom.xml

```xml
     <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

 <!-- 使用Apache HttpClient替换Feign原生httpURLConnection -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
        </dependency>
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-httpclient</artifactId>
            <version>10.1.0</version>
        </dependency>
```

2、启动类添加注解@EnableFeignClients

3、配置feign
```yaml
feign:
#  #文件压缩
#  compression:
#    request:
#      enabled: true
#      min-request-size: 512
#      mime-types: text/xml,application/json
  #日志输出

#  client:
#    config:
#      service-goods:
#        loggerLevel: FULL
#      defalut:
#        connect-timeout: 60000
#        read-timeout: 60000
  httpclient:
    enabled: true
    connection-timeout: 60000
    connection-timer-repeat: 60000
  hystrix:
    enabled: true
```

4、写相应的调用接口
```java
@FeignClient(name ="service-goods",fallback = GoodsServiceFallback.class)
public interface GoodsService {

    @RequestMapping("/goods/{id}")
    GoodsVo findById(@RequestParam(value = "id")Long id);

    @RequestMapping(value = "/goods/save",method = RequestMethod.POST)
    public String save(@RequestBody GoodsVo goods);
}
```



### 底层原理

优秀文章：https://www.cnblogs.com/crazymakercircle/p/11965726.html

![来源疯狂创客圈](https://img-blog.csdnimg.cn/20191201125843452.png)





































