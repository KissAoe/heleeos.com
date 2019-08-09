---
title: Linux下使用NodeJS
thumbnail: 'https://picsum.photos/300/200?random=7'
info: 'centos 7 下安装NodeJS, 并运行用 express 开发的程序'
recent: false
date: 2017-04-05 16:18:51
url:
category:
tags:
---

## 依赖条件

### 1.下载NodeJS执行文件

[官网下载页面](https://nodejs.org/en/download/)

```
wget https://nodejs.org/dist/v6.10.1/node-v6.10.1-linux-x64.tar.xz
```

### 2.安装依赖工具

```
yum install -y xz
```


## 解压并使用

### 1.解压下载的安装包

```
xz -d node-v6.10.1-linux-x64.tar.xz
tar -xvf node-v6.10.1-linux-x64.tar
```

### 2.移动目录并重命名

把当前的解压的移动为 `/usr/local/nodejs`

```
mv node-v6.10.1-linux-x64 /usr/local/
cd /usr/local/
mv node-v6.10.1-linux-x64/ nodejs
```

### 3.添加环境变量

```
vim /etc/profile
```

在文件的末尾加上 `export PATH=/usr/local/nodejs/bin:$PATH`, 关闭 SSH 连接并重新打开一个新的


### 4.测试

```
node -v
npm -v
```

## 安装库

### 1.修改 npm 的数据源
> 修改npm的数据源为淘宝的`https://registry.npm.taobao.org/`
```
npm config set registry https://registry.npm.taobao.org/
```

### 2.安装 express

```
npm install -g express
```

```
DEBUG=myserver:* npm start
```

### 3.安装 forever

```
npm install -g forever
```

```
forever start bin/www
```