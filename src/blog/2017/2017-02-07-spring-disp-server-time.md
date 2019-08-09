---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-02-07 10:13:05
url:
category:
tags:
---

## 编程前提

1. 知道Maven是如何管理项目的. [Apache Maven](https://maven.apache.org/)
2. 会使用Eclipse EE 或者 [Spring Tool Suite™ (STS)](https://spring.io/tools/sts)
3. 有基本的Java编程基础,知道MVC等概念

## 编程环境

- JDK: 1.8.0_91
- IDE: STS 3.7.3.RELEASE
- Maven: Apache maven 3.3.9
- Server: Apache Tomcat 7.0

## 步骤详解

### 新建一个Maven项目

![](/assets/image/blog/spring-disp-server-time/1.png)

### 选择建立简单项目

![](/assets/image/blog/spring-disp-server-time/2.png)

### 填写项目基本信息

![](/assets/image/blog/spring-disp-server-time/3.png)

![](/assets/image/blog/spring-disp-server-time/4.png)

>刚建立完成有错误很正常,因为我们建立的是最简单的项目,不包含其他任何配置

### 新增配置文件

1. 修改pom.xml文件
2. 先在webapp下面新建一个WEB-INF文件夹,然后新建一个文件,命名为web.xml,然后依次建立pages文件夹和dispatcher-servlet.xml
3. 另外在src/main/resources 下面新建 applicationContext.xml文件

![](/assets/image/blog/spring-disp-server-time/6.png)

![](/assets/image/blog/spring-disp-server-time/5.png)

### maven更新项目

![](/assets/image/blog/spring-disp-server-time/7.png)


### 新建控制器

在src/main/java 下面新建包 com.helios.controller, 然后新建 MainController 类

![](/assets/image/blog/spring-disp-server-time/8.png)

### 编写首页内容

在WEB-INF/pages 下面新建一个文件 名为 index.ftl

![](/assets/image/blog/spring-disp-server-time/9.png)

![](/assets/image/blog/spring-disp-server-time/10.png)

### 运行和测试

![](/assets/image/blog/spring-disp-server-time/11.png)

![](/assets/image/blog/spring-disp-server-time/12.png)

![](/assets/image/blog/spring-disp-server-time/13.png)

### 编写时间内容

MainController中新增加一个方法 toTime, pages 下新增一个 time.ftl 文件

![](/assets/image/blog/spring-disp-server-time/14.png)

![](/assets/image/blog/spring-disp-server-time/15.png)

### 运行和测试

![](/assets/image/blog/spring-disp-server-time/16.png)

## 文件附录

[代码已上传码云](https://git.oschina.net/IP/LearnSpring)