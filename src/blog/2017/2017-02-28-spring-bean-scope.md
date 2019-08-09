---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-02-28 09:10:57
url:
category:
tags:
---

## Scope分类

| scope 范围  | 说明 |
|:----|:------|
|singleton    | （默认）每个Spring IoC容器定义单个bean实例|
|prototype    | 任意数量的对象实例|
|request      | 每个HTTP请求都有自己的Bean实例|
|session      | HTTP会话的生命周期将共用同一个Bean实例|
|globalSession| 全局HTTP会话的生命周期将共用同一个Bean实例。仅在Portlet上下文中使用时有效|
|application  | ServletContext的生命周期将共用一个Bean实例|
|websocket    | WebSocket的生命周期将共用同一个Bean实例|

其中 request, session,  globalSession, application, websocket  只有使用Web的容器时候才有效.如果在ClassPathXmlApplicationContext中使用时,将会抛出IllegalStateException

## Scope详解

### Singleton(单例)

只管理bean的一个共享实例，并且Spring容器对所有对具有与该bean定义匹配的请求返回同一个bean实例。也就是说，当一个bean作为一个singleton作用域时，Spring IoC容器只创建一个该bean定义的对象​​实例。这个实例存储在缓存中，所有后续请求和引用都返回缓存的对象。如下图所示:

![](/assets/image/blog/spring-bean-scope/1.png)

Spring的单例模式，不同于设计模式中的单例模式，Spring的单例模式是强制同一个容器只创建和使用一个实例，而设计模式中的单例模式是强制每个ClassLoader只创建一个实例。

### Prototype(原型)

每次对bean的请求时都会创建新的bean实例。bean被注入到另一个bean中，或者通过对容器的getBean()方法调用来请求它。

![](/assets/image/blog/spring-bean-scope/2.png)

Spring容器对原型作用域bean的创建，其实就是替代Java new操作符。

不管范围如何，所有对象会调用初始化生命周期方法(init-method)，但在原型的情况下，Bean不会回调销毁生命周期方法(destroy-method)

> **通常，对所有有状态bean使用原型作用域，对无状态bean使用单例作用域。**

## 测试代码

[测试代码](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/beans/TestBeanScope.java)

[Bean定义](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/resources/applicationBeanTest.xml)

测试结果如下图:

![](/assets/image/blog/spring-bean-scope/3.png)