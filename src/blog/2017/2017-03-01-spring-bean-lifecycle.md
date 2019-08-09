---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-03-01 09:10:57
url:
category:
tags:
---

## 一、对象的初始化和销毁

### 初始化

| 方式 | 说明 | 优点 | 缺点 |
|:----|:----|:----|:----|
|接口|对象实现InitializingBean接口|清晰明了|代码和Sping耦合|
|注解|JSR-250生命周期注解 @PostConstruct| 代码解耦 | 无 |
|配置|xml中配置init-method 或者 注解中配置 initMethod | 代码解耦 | 无 |
|默认|xml中配置default-init-method | 代码解耦 | 无 |

执行的顺序为:

1. @PostConstruct
2. InitializingBean的afterPropertiesSet()
3. 配置的init

>  配置的 init-method 会覆盖 默认的 default-init-method

### 销毁

| 方式 | 说明 | 优点 | 缺点 |
|:----|:----|:----|:----|
|接口|对象实现DisposableBean接口|清晰明了|代码和Sping耦合|
|注解|JSR-250生命周期注解 @PreDestroy| 代码解耦 | 无 |
|配置|xml中配置destroy-method 或者 注解中配置 destroyMethod | 代码解耦 | 无 |
|默认|xml中配置default-destroy-method | 代码解耦 | 无 |

执行的顺序为:

1. @PreDestroy
2. DisposableBean的destroy()
3. 配置的destroy

>  配置的 destroy-method 会覆盖 默认的 default-destroy-method

### 使用方法

```
<beans default-init-method="init" default-destroy-method="dispose" ... >
     
    <!-- 采用指定的初始化和销毁,onCreate(),onDestroy() -->
    <bean id="testBean1" class="com.helios.bean.LifecycleBean" init-method="onCreate" destroy-method="onDestroy">
        <property name="name" value="Bean1"/>
    </bean>
    
    <!-- 采用默认的初始化和销毁,init(),dispose() -->
    <bean id="testBean2" class="com.helios.bean.LifecycleBean">
        <property name="name" value="Bean2"/>
    </bean>
    
</beans>
```

### 测试代码

[Bean的定义](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/bean/LifecycleBean.java)

[Bean的测试运行代码](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/beans/TestBeanLife.java)

[Bean的声明代码](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/resources/applicationBeanTest.xml)

### 测试结果

一个对象的初始化生命周期

![](/assets/image/blog/spring-bean-lifecycle/1.png)

一个对象完整的生命周期

![](/assets/image/blog/spring-bean-lifecycle/2.png)

多个对象的完整的生命周期

![](/assets/image/blog/spring-bean-lifecycle/3.png)

一个对象的生命周期，所有的初始化和销毁回调函数为同一个

![](/assets/image/blog/spring-bean-lifecycle/4.png)

### 总结流程图

![](/assets/image/blog/spring-bean-lifecycle/5.png)

## 二、通过 Lifecycle 实现自定义流程

任何Spring托管的对象都可以实现Lifecycle接口,当ApplicationContext本身接收到开始和停止信号时，委托给一个LifecycleProcessor，调用到在该上下文中定义的所有Lifecycle的实现。

> Spring 默认是委托给 org.springframework.context.support.DefaultLifecycleProcessor 处理的

LifecycleProcessor本身是Lifecycle接口的扩展。它还添加了onRefresh() 和 onClose() 两个方法。

> Lifecycle 只定义了 start() 和 stop()，实际上是不会真正调用的。SmartLifecycle是Lifecycle接口的扩展，新增加了isAutoStartup()来告诉LifecycleProcessor是否启动。

销毁之前并不一定能够收到停止通知:

- 在正常关闭时，所有Lifecycle bean在销毁回调之前接收停止通知。

- 在上下文的生命周期中的 hot refresh 或 aborted refresh，只有销毁方法将被调用。

### 类关系图

![](/assets/image/blog/spring-bean-lifecycle/6.png)

### 测试代码

[MySmartLifecycle.java](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/bean/MySmartLifecycle.java)

### 测试结果

![](/assets/image/blog/spring-bean-lifecycle/7.png)

启动的流程，只适用于 SmartLifecycle

1. LifecycleProcessor 会调用 SmartLifecycle 的 isAutoStartup() 来查看是否运行
2. 如果上一步为 true 会调用 getPhase() 来查看运行顺序，int范围，数值越大，越先执行
3. 调用 isRunning() 来查看当前的运行状态
4. 如果上一步为 false 会调用 start()

关闭的流程，适用于 Lifecycle

1. 调用 SmartLifecycle 的 getPhase() 来查看运行顺序
2. 调用 Lifecycle 的 isRunning() 来查看当前的运行状态
3. 如果上一步为 true 会调用 stop()

### 同时多种初始化和销毁

[测试代码](https://git.oschina.net/IP/LearnSpring/blob/master/src/test/java/com/helios/bean/MySmartLifecycle2.java)

![](/assets/image/blog/spring-bean-lifecycle/8.png)

### 总结流程图

![](/assets/image/blog/spring-bean-lifecycle/9.png)