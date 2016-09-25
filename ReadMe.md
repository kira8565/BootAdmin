# 主要技术

* Spring Boot：简单易用，带了MVC和IOC的功能
* Spring Security:权限校验，不用Shiro的原因是。。都整合好了，省事很多呢
* flat-admin:这UI长得还不错
* Hibernate，Spring Data JPA：采用Spring Data JPA来整合Hibernate，
校验层面也采用了Hibernate的Validator，省事。IDEA的生成也挺方便的，
新写的注解不会被覆盖掉，都是追加的
* Guava:基础库，少不了~
* Freemaker:本来想用JSP的，然而发现官方文档说慎用，好吧，那
Velocity，结果1.4开始被弃用了，那就Freemaker吧。。反正也用过
* FastJson：比Gson好用些，Gson有些奇奇怪挂的Bug在这个库没碰到过
* MySQL：这个就。。没什么好说的了，不过开发的时候用的MariaDB