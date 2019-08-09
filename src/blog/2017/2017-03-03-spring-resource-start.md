---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-03-03 16:10:57
url:
category:
tags:
---

## Resource简介

### 1.介绍

### 2.类图 

### 3.Resource分类

| 资源类                 | 支持写出 | 封装的底层                   | 说明                            |
| :--------------------- | :------- | :--------------------------- | :------------------------------ |
| ClassPathResource      | ×        | java.lang.ClassLoader        | 从类路径获取资源                |
| ServletContextResource | ×        | javax.servlet.ServletContext | 从Web应用程序的根目录中获取资源 |
| UrlResource            | ×        | java.net.URL/URI             | 通过URL获取资源                 |
| ByteArrayResource      | ×        | byte[]                       | 从字节数组中获取资源            |
| InputStreamResource    | ×        | java.io.InputStream          | 包装一下InputStream             |
| VfsResource            | ×        | org.jboss.vfs.VirtualFile    | 包装JBoss的vfs                  |
| FileSystemResource     | √        | java.io.File                 | 包装一下File句柄                |
| PathResource           | √        | java.nio.file.Path           | 包装一下Path                    |

### 4.Resource加载器


### 5.文件前缀

| 前缀       | 举例                                                               | 说明                               |
| :--------- | :----------------------------------------------------------------- | :--------------------------------- |
| classpath: | classpath:com/heleeos/config.xml                                   | 从类的路径中获取,ClassPathResource |
| file:      | file:///var/apps/Blog-heleeos/Web-INF/class/com/heleeos/config.xml | FileSystemResource                 |
| http:      | http://heleeos.com/logo.png                                        | UrlResource                        |
| jar:       |
| war:       |
| 空         | 取决于加载器                                                       |


## Resource详细介绍

### 1.