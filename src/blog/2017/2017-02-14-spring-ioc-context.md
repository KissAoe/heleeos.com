---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-02-14 15:15:16
url:
category:
tags:
---

## 简介

使用开发工具进行 debug 分析一个 ApplicationContext 初始化过程

###开发条件

| 组件   | 版本 |
| :----- | :------ |
| JDK    | 1.8.0_91 |
| Spring | 4.3.3  |
| IDE    | STS 3.7.3 |

## 容器初始化分析

### 执行 AbstractApplicationContext 的 static 块

### 执行 ClassPathXmlApplicationContext 的构造方法

1.初始化 AbstractXmlApplicationContext

2.初始化 AbstractRefreshableConfigApplicationContext

3.初始化 AbstractRefreshableApplicationContext

4.初始化 AbstractApplicationContext

5.初始化 DefaultResourceLoader

6.执行 ClassUtils 的 getDefaultClassLoader 返回结果为 sun.misc.Launcher$AppClassLoader

7.初始化 AbstractApplicationContext  的成员属性

8.执行 AbstractRefreshableApplicationContext 的 getResourcePatternResolver

9.初始化 PathMatchingResourcePatternResolver 

10.初始化 AntPathMatcher

11.执行 AbstractRefreshableConfigApplicationContext 的 setConfigLocations

12.执行 AbstractRefreshableConfigApplicationContext 的 resolvePath

13.执行 AbstractApplicationContext 的 createEnvironment 返回一个新的 StandardEnvironment

14.执行 AbstractApplicationContext 的 refresh

15.执行 AbstractPropertyResolver 的 validateRequiredProperties

16.执行 AbstractApplicationContext  的 obtainFreshBeanFactory

17.执行 AbstractRefreshableApplicationContext  的 refreshBeanFactory

18.执行 AbstractRefreshableApplicationContext  的 createBeanFactory

19.初始化 DefaultListableBeanFactory

20.加载 javax.inject.Provider

21.执行 AbstractXmlApplicationContext 的  loadBeanDefinitions

22.初始化 XmlBeanDefinitionReader

23.执行 AbstractApplicationContext 的 prepareBeanFactory

24.执行 AbstractApplicationContext 的 initLifecycleProcessor

25.发出 ContextRefreshedEvent 事件

##工厂创建Bean分析

1.清除 Bean Name 中的 FACTORY_BEAN_PREFIX ( '&' ) 标记

2.执行 DefaultSingletonBeanRegistry 的 getSingleton

....