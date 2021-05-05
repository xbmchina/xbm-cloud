## gateway网关

官方文档：

https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/

![原理图](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/images/spring_cloud_gateway_diagram.png)

三大核心：

* Filter（过滤器）
* Route（路由）
* Predicate（断言）


优秀博客：

https://www.cnblogs.com/crazymakercircle/p/11704077.html


## 其他补充

1、nacos动态刷新网关配置

参考xbm-gateway模块中的NacosDynamicRouteService.java

2、聚合swagger文档

参考xbm-gateway模块中的swaggerHandler.java和SwaggerProvider.java


3、gateway+oauth2+jwt+security

参考xbm-auth模块和xbm-gateway模块

http://www.macrozheng.com/#/cloud/gateway_oauth2?id=micro-oauth2-auth


4、gateway配置yaml转json

https://blog.csdn.net/AWen_Jack/article/details/106019979




















