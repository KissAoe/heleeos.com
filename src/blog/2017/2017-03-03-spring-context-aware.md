---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-03-03 09:10:57
url:
category:
tags:
---

## 一、通过 Aware 获取功能依赖

Spring提供了一系列Aware接口，允许bean向容器获取它们需要的功能。

### 所有的已知的 Aware

![](/assets/image/blog/spring-context-aware/1.png)

### 测试代码

[Aware测试代码](https://git.oschina.net/IP/LearnSpring/tree/master/src/test/java/com/helios/aware)

### 测试结果

![](/assets/image/blog/spring-context-aware/2.png)

## 二、通过 BeanPostProcessor 定制 Bean 

如果想在Spring容器完成实例化，配置和初始化bean之后实现一些自定义逻辑，可以定义一个或多个BeanPostProcessor的实现。BeanPostProcessor接口定义了 postProcessBeforeInitialization() 和 postProcessAfterInitialization() 两个方法，通过实现这2个方法来提供自己的（或覆盖容器的默认）实例化逻辑，依赖解析逻辑等等。

> 1.BeanPostProcessor 作用域是容器

> 2.可以通过实现 Ordered 接口来控制这些BeanPostProcessor执行的顺序

### 测试代码

[测试代码 - MyBeanPostProcessor.java](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/bean/MyBeanPostProcessor.java)

### 测试结果

![](/assets/image/blog/spring-context-aware/3.png)

执行顺序:

1. Bean的构造方法
2. Bean的setter
3. 容器中 BeanPostProcessor 的 before
4. Bean的初始化方法
5. 容器中 BeanPostProcessor 的 after

## 三、通过 BeanFactoryPostProcessor 定制 Bean 元数据配置

BeanFactoryPostProcessor对bean配置元数据进行操作，也就是说，Spring IoC容器允许BeanFactoryPostProcessor读取配置元数据，并在容器实例化之前更改它。

> 1.BeanFactoryPostProcessors 作用域是容器

> 2.可以通过实现 Ordered 接口来控制这些BeanFactoryPostProcessor执行的顺序

###自定义 BeanFactoryPostProcessor

[测试代码 - MyBeanFactoryPostProcessor.java](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/bean/MyBeanFactoryPostProcessor.java)

结果如下图所示:

![](/assets/image/blog/spring-context-aware/4.png)

- 获取容器中所有Bean的定义
- 并且是在所有的Bean初始化之前

**下面介绍两个 Spring 提供的，常用的 BeanFactoryPostProcessor 实现**

###PropertyPlaceholderConfigurer 

运行时把 bean 定义时使用的 ${} 替换成 配置文件 中的具体的值。

properties 中定义的 key=value 例如: username = root

###PropertyOverrideConfigurer

运行是把 配置文件 中具体的值 覆盖到对应的 bean

properties 中定义的 bean.key=value 例如: dataSource.username = admin

### 测试代码

[Bean的定义 - MyDataSource.java](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/bean/MyDataSource.java)

[Bean的使用 - TestMyDataSource.java](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/beans/TestMyDataSource.java)

[Bean的配置 - application-bean-datasource.xml](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/resources/application-bean-datasource.xml)

```
#jdbc1.properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://127.0.0.1:3306
jdbc.username=admin
jdbc.password=adminPass
```

```
#jdbc2.properties
dataSource2.username=root
dataSource2.password=pass
```

### 测试结果

![](/assets/image/blog/spring-context-aware/5.png)

dataSource1 中 把所有的 ${} 都替换成 配置文件中的值

dataSource2 中 把 配置文件中 存在的值 覆盖了

## 四、通过 FactoryBean 定制 Bean 实例化逻辑

当有复杂的初始化代码时候，用 Java 代码编写要比用 XML 编写更好，这时候就可以创建FactoryBean，在该类中编写复杂的初始化，然后将自定义FactoryBean托管到容器中。

### 测试代码

[MyFactoryBean.java](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/bean/MyFactoryBean.java)

### 测试结果

![](/assets/image/blog/spring-context-aware/6.png)

### BeanFactory 和 FactoryBean 的区别

- BeanFactory 是一个工厂，用来直接获取对象
- FactoryBean 是一个模具，用来生产具体的对象(实例化的逻辑)