---
title: Linux下安装MySQL
thumbnail: 'https://picsum.photos/300/200?random=7'
info: 'linux下通过源码安装mysql'
recent: false
date: 2017-03-29 09:58:19
url: 'linux-install-mysql'
category:
tags:
---

## 一、依赖条件

### 1.下载Mysql

`https://cdn.mysql.com/Downloads/MySQL-5.7/mysql-5.7.17.tar.gz`

### 2.下载Boost

`https://nchc.dl.sourceforge.net/project/boost/boost/1.59.0/boost_1_59_0.tar.gz`

### 3.安装依赖工具

`yum install -y gcc gcc-c++ bison ncurses ncurses-devel cmake`

![](/assets/image/blog/linux-install-source-mysql/1.png)

### 4.准备boost

解压 `boost_1_59_0.tar.gz` 压缩包

```
tar -zxvf boost_1_59_0.tar.gz
```

![](/assets/image/blog/linux-install-source-mysql/2.png)

移动到 `/usr/local` 下并重命名为 `boost`

``` 
mv boost_1_59_0 /usr/local/ 
mv /usr/local/boost_1_59_0/ /usr/local/boost/ 
```

![](/assets/image/blog/linux-install-source-mysql/3.png)

## 帐号和目录

### 1.准备帐号

新增用户和群组 `mysql` 并且不能够登陆

```
groupadd mysql
useradd mysql -g mysql -M -s /sbin/nologin
```

![](/assets/image/blog/linux-install-source-mysql/4.png)

### 2.创建目录

创建安装目录 `/usr/local/mysql` 和数据目录 `/var/mysqldata`

```
mkdir -p /usr/local/mysql
mkdir -p /var/mysqldata
```

![](/assets/image/blog/linux-install-source-mysql/5.png)

### 3.修改属性

```
chown -R mysql:mysql /usr/local/mysql
chown -R mysql:mysql /var/mysqldata
```

![](/assets/image/blog/linux-install-source-mysql/6.png)

## 编译Mysql源码

### 1.解压源码压缩包

```
tar -zxvf mysql-5.7.17.tar.gz
```

![](/assets/image/blog/linux-install-source-mysql/7.png)

### 2.编译安装mysql

进行编译前配置

- 安装目录 `DCMAKE_INSTALL_PREFIX` 为 `/usr/local/mysql`
- 数据目录 `DMYSQL_DATADIR` 为 `/var/mysqldata`
- 配置目录 `DSYSCONFDIR` 为 `/etc`
- boost目录 `DWITH_BOOST` 为 `/usr/local/boost`

```
cmake -DCMAKE_INSTALL_PREFIX=/usr/local/mysql \
-DMYSQL_DATADIR=/var/mysqldata \
-DSYSCONFDIR=/etc \
-DMYSQL_UNIX_ADDR=/tmp/mysql.sock \
-DMYSQL_USER=mysql \
-DMYSQL_TCP_PORT=3306 \
-DWITH_MYISAM_STORAGE_ENGINE=1 \
-DWITH_INNOBASE_STORAGE_ENGINE=1 \
-DWITH_MEMORY_STORAGE_ENGINE=1 \
-DWITH_PARTITION_STORAGE_ENGINE=1 \
-DDEFAULT_CHARSET=utf8 \
-DDEFAULT_COLLATION=utf8_general_ci \
-DEXTRA_CHARSETS=all \
-DENABLED_LOCAL_INFILE=1 \
-DWITH_BOOST=/usr/local/boost
```

![](/assets/image/blog/linux-install-source-mysql/8.png)

配置完成后如下图所示

![](/assets/image/blog/linux-install-source-mysql/9.png)

开始编译安装
```
make && make install
```
![](/assets/image/blog/linux-install-source-mysql/10.png)

等待30 ~ 50 分钟

![](/assets/image/blog/linux-install-source-mysql/11.png)

### 3.修改配置文件

根据刚才配置的配置目录 `DSYSCONFDIR` 为 `/etc` , 所以修改命令为

```
vim /etc/my.cnf
```

![](/assets/image/blog/linux-install-source-mysql/12.png)

[参考配置 - my.cnf](/assets/image/blog/linux-install-source-mysql/my.cnf)

### 4.初始化

```
/usr/local/mysql/bin/mysqld --initialize --user=mysql --datadir=/var/mysqldata/ --basedir=/usr/local/mysql/ &
```

![](/assets/image/blog/linux-install-source-mysql/13.png)

红框中的为数据库 `root` 的初始密码

## 使用mysql

### 1.启动

```
/usr/local/mysql/bin/mysqld_safe --basedir=/usr/local/mysql --datadir=/var/mysqldata/ --user=mysql
```
如果提示出错 `Create writable for user 'mysql'` 可以执行 `touch && chown`

![](/assets/image/blog/linux-install-source-mysql/14.png)

```
touch centos-test.err
chown -R mysql:mysql /var/mysqldata
```

![](/assets/image/blog/linux-install-source-mysql/15.png)

正确启动界面如下:

![](/assets/image/blog/linux-install-source-mysql/16.png)

### 2.连接mysql

```
/usr/local/mysql/bin/mysql -uroot -p
```

然后输入刚才的生成的初始化密码

![](/assets/image/blog/linux-install-source-mysql/17.png)

### 3.修改密码

```
set password for 'root'@'localhost'=password('admin');
```

![](/assets/image/blog/linux-install-source-mysql/18.png)

## Mysql常见问题

### 1.重置密码

如果忘记root密码或者不记得初始化密码,可以通过 `skip-grant-tables` 重置密码

```
/usr/local/mysql/bin/mysqld_safe --basedir=/usr/local/mysql --datadir=/var/mysqldata/ --user=mysql --skip-grant-tables &
```
然后可以直接用`root`登陆进去
```
/usr/local/mysql/bin/mysql -uroot
```

![](/assets/image/blog/linux-install-source-mysql/19.png)

### 2.创建用户
创建`root`用户, 密码为`admin`, 登陆主机限制为`%`(不限制), 并授权`all`
```
CREATE USER 'root'@'%' IDENTIFIED BY 'admin';

GRANT all ON *.* TO 'root'@'%';
```

### 3.定期备份
备份的原理主要是执行 `mysqldump`, Linux系统下是 `crontab`

编写一个shell脚本 `backupmysql.sh`

```
#!/bin/bash

time=` date +%Y%m%d `

/usr/local/mysql/bin/mysqldump -u用户名 -p密码 数据库 > /var/mysqlbackup/database_$time.sql(保存的文件)
```

1. 指定文件 `crontab /etc/crontab`
2. 便捷文件 `crontab -e`
3. 编写指令 `30 * * * * root /var/mysqlbackup/backupmysql.sh`, 表示当分钟为30时进行执行


crontab的格式如下:
<pre>
.---------------- minute (0 - 59)
|  .------------- hour (0 - 23)
|  |  .---------- day of month (1 - 31)
|  |  |  .------- month (1 - 12) OR jan,feb,mar,apr ...
|  |  |  |  .---- day of week (0 - 6) (Sunday=0 or 7) OR sun,mon,tue,wed,thu,fri,sat
|  |  |  |  |
*  *  *  *  * user-name  command to be executed
分 时 日 月 星期 用户 命令
</pre>