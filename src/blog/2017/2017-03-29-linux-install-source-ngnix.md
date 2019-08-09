---
title: Linux下编译安装Nginx
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-03-29 14:06:43
url:
category:
tags:
---

## 依赖条件

### 1.下载Nginx源码
[官网下载页面](https://nginx.org/en/download.html)

`https://nginx.org/download/nginx-1.11.12.tar.gz`

### 2.安装依赖工具
```
yum install -y openssl-devel zlib-devel pcre-devel
```
## 编译Nginx源码

### 1.解压Nginx源码压缩包

```
tar -zxvf nginx-1.11.12.tar.gz
```
![](/assets/image/blog/linux-install-source-ngnix/1.png)

### 2.编译安装Ngnix

进行编译前配置
- 安装目录 `prefix` 为 `/usr/local/nginx`
- 包含 `http_stub_status_module` 模块
- 包含 `http_gzip_static_module` 模块
- 包含 `http_ssl_module` 模块

```
./configure --prefix=/usr/local/nginx --with-http_stub_status_module --with-http_gzip_static_module --with-http_ssl_module
```

![](/assets/image/blog/linux-install-source-ngnix/2.png)

配置完成后如下图

![](/assets/image/blog/linux-install-source-ngnix/3.png)

开始编译安装

```
make && make install
```
![](/assets/image/blog/linux-install-source-ngnix/4.png)

安装完成后如下图

![](/assets/image/blog/linux-install-source-ngnix/5.png)
### 3.修改配置文件

```
vim /usr/local/nginx/conf/nginx.conf
```

[参考配置 - nginx.conf](/assets/image/blog/linux-install-source-ngnix/nginx.conf)

### 4.启动
```
/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf
```

### 5.重新加载

修改配置文件后, 重新加载配置文件

```
/usr/local/nginx/sbin/nginx -s reload
```