## seata分布式事务

官网：

https://seata.io/zh-cn/docs/overview/what-is-seata.html


## 集成教程

https://www.cnblogs.com/chinaWu/p/13255200.html

https://www.cnblogs.com/dalianpai/p/12443676.html

## 存在疑问

* 1、AT模式下，没法做到强一致性，只能是最终一致性。（因为2段提交，会出现脏读现象）
* 2、TCC模式下是否存在脏读?是否存在有强一致性的模式?
* 3、由于feign存在重试机制，如何保证接口幂等性?
* 4、各种模式的性能比较如何?
* 5、是否可以在业务上，通过垂直分库的办法，避免使用分布式事务框架?