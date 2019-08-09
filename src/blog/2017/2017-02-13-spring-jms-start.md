---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-02-13 09:10:57
url:
category:
tags:
---

## 准备条件

使用ActiveMQ搭建一个消息中间件，通过Spring的spring-jms组件来进行收、发消息

### 开发条件

| 组件 | 版本 |
| :----- | :------|
| JDK | 1.8.0_91 |
| Spring | 4.3.3  |
| IDE | STS 3.7.3 |
| ActiveMQ | 5.14.3 |

### ActiveMQ的安装和使用

1.下载

[ActiveMQ官方下载地址](http://activemq.apache.org/download.html)

![](/assets/image/blog/spring-jms-start/1.png)

2.解压

![](/assets/image/blog/spring-jms-start/2.png)

3.启动

![](/assets/image/blog/spring-jms-start/3.png)

4.测试

先查看下是否启动成功，然后再查看下是否有端口监听

![](/assets/image/blog/spring-jms-start/4.png)

地址栏输入 {HOST}:8161/admin , 用户名和密码均是 admin

![](/assets/image/blog/spring-jms-start/5.png)

## 消息的发送

1.配置工厂

2.配置模板

3.发送消息

4.测试代码

[TestSendMessage.java](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/jms/TestSendMessage.java)

## 消息的接受

1.配置工厂

2.配置监听器

## 进阶内容