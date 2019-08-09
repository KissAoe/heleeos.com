---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-02-07 09:10:21
url:
category:
tags:
---

## Spring 简介

Spring是一个Java平台的开源框架，为开发Java应用程序提供全面的基础架构支持。Spring处理基础架构，以便开发人员可以专注于应用程序。Spring使开发人员能够使用"纯Java对象"（POJO）构建应用程序，并将服务非侵入性的应用于POJO。

虽然Java平台提供了丰富的应用程序开发功能，但它缺乏将基本构建块组织成一个整体的手段，将该任务留给架构师和开发人员。可以使用Factory, Abstract Factory, Builder, Decorator等设计模式来组成构成应用程序的各种类和对象实例，但这些模式仅仅是：给定名称以及描述什么模式，应用它解决的问题。模式都是形式化的，开发人员必须在应用程序中实现自己的模式代码。Spring框架通过使用控制反转（IoC）组件，将完全不同的组件，组合成可以工作的应用程序，来解决这个问题。

## Spring 组成

![](/assets/image/blog/spring-info/1.png)

图片来源  [Spring 官方文档](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/overview.html#overview-modules)

## Spring 模块说明

| 模块名称                 | 模块描述                                             |
| :----------------------- | :--------------------------------------------------- |
| spring-aop               | 基于代理的AOP                                        |
| spring-aspects           | 基于AspectJ的切面                                    |
| spring-beans             | Bean支持，包括Groovy                                 |
| spring-context           | 应用程序上下文运行时，包括调度和远程抽象             |
| spring-context-support   | 支持将常见的第三方库集成到Spring应用程序上下文中的类 |
| spring-core              | 核心实用程序，由许多其他Spring模块使用               |
| spring-expression        | Spring表达式语言（SpEL）                             |
| spring-instrument        | JVM引导的工具代理                                    |
| spring-instrument-tomcat | Tomcat的工具代理                                     |
| spring-jdbc              | JDBC支持包，包括DataSource设置和JDBC访问支持         |
| spring-jms               | JMS支持包，包括用于发送和接收JMS消息的助手类         |
| spring-messaging         | 支持消息架构和协议                                   |
| spring-orm               | 对象/关系映射，包括JPA和Hibernate支持                |
| spring-oxm               | 对象/ XML映射                                        |
| spring-test              | 支持单元测试和集成测试Spring组件                     |
| spring-tx                | 事务基础，包括DAO支持和JCA集成                       |
| spring-web               | Web支持包，包括客户端和Web远程处理                   |
| spring-webmvc            | Web应用程序的REST Web服务和模型 - 视图 - 控制器实现  |
| spring-webmvc-portlet    | 将在Portlet环境中使用的MVC实现                       |
| spring-websocket         | WebSocket和SockJS实现，包括STOMP支持                 |

## Spring 部分类图

### BeanFactory类图

![BeanFactory类图](/assets/image/blog/spring-info/2.png)

## Spring 模块源码下载

使用svn工具下载 Spring github 的部分源码

### 打开Spring的github

浏览器打开链接 [https://github.com/spring-projects/spring-framework](https://github.com/spring-projects/spring-framework)

### 寻找要下载的模块

![](/assets/image/blog/spring-info/3.png)

### 修改地址

将地址中的 tree/master 修改为 trunk

将地址 `https://github.com/spring-projects/spring-framework/`**tree/master**`/spring-web/`

修改为 `https://github.com/spring-projects/spring-framework/`**trunk**`/spring-web/`

### svn中导出

![](/assets/image/blog/spring-info/4.png)

![](/assets/image/blog/spring-info/5.png)