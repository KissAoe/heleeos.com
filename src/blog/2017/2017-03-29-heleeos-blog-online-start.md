---
title: 本博客网站技术分享
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-03-29 13:25:54
url:
category:
tags:
---

## Heleeos Blog 技术分享

### 1.功能列表及完成情况

![](/assets/image/blog/heleeos-blog-online-start/1.png)

Web端

- 博客读取
- 缓存读取
- Markdown解析
- 响应式界面
- 目录列表
- 标签列表
- 分类列表

Manager 端

- 管理界面
- 分类管理
- 标签管理
- 文章管理

### 2.技术架构

![](/assets/image/blog/heleeos-blog-online-start/2.png)

- Nginx - 负责监听域名和使用SSL
- Controller - 负责将用户的请求渲染成视图, 使用的框架是 `Spring`
- DataService - 负责读取数据, 使用的框架是 `Mybatis`
- Mysql - 负责存储文章等信息

### 3.请求流程图

![](/assets/image/blog/heleeos-blog-online-start/3.png)

一个比较常规的请求示意图

### 4.新的版本技术架构

![](/assets/image/blog/heleeos-blog-online-start/4.png)

- Nginx - 负责代理静态文件, 监听域名和使用SSL
- NodeJS - 负责生成静态文件和解析Markdown
- BlogService - 负责处理博客的整体服务, 使用的框架是 `Spring Boot`
- DataService - 负责读取数据, 使用的框架是 `Mybatis`
- Mysql - 负责存储文章等信息

### 5.新的版本请求流程图

![](/assets/image/blog/heleeos-blog-online-start/5.png)