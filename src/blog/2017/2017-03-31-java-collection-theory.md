---
title: Java集合总结
thumbnail: 'https://picsum.photos/300/200?random=7'
info: 'Java常用的集合总结, 以及常用的方法, 区别等等'
recent: false
date: 2017-03-31 11:07:42
url:
category:
tags:
---

## 一、Java集合概述

### 1.集合类图
![](/assets/image/blog/java-collection-theory/uml.png)

### 2.集合实现总结

|接口|Hash表|数组可变大小|平衡树|链表|Hash表 + 链表|
|:---|:-----|:-----------|:-----|:---|:------------|
|Set||HashSet|           |TreeSet|   |LinkedHashSet|
|List|      |ArrayList   |      |LinkedList|       |
|Deque|     |ArrayDeque  |      |LinkedList|       |
|Map|HashMap|            |TreeMap|   |LinkedHashMap|

## 二、集合接口

### 1.Iterable

>实现这个接口的对象能够成为`for-each loop`语句的目标

[for-each介绍](https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html)

- iterator() 返回一个迭代器
- forEach() Java8新增, 主要用户面向函数的循环方式
- spliterator() Java8新增, 返回一个拼接器

### 2.Collection

> 一组元素组成的对象成为集合

- add(object) 新增一个元素
- remove(object) 删除一个元素
- clear() 清空集合
- stream() 返回该集合的顺序流
- toArray() 返回该集合元素组成的数组

### 3.Queue(队列)

> 处理之前保留元素的一种集合

- offer(object) 在容量允许的情况下, 插入元素
- element() 获取头元素, 但是不移除, 队列为空, 抛出异常
- peek() 获取第一个元素, 但是不移除, 队列为空, 返回null
- remove() 获取第一个元素, 并删除, 队列为空, 抛出异常
- pool() 获取第一个元素, 并删除, 队列为空, 返回null

### 4.Deque(双端队列)

> 支持两端元素操作的线性集合

- pop() 删除并返回第一个元素
- push(object) 在集合的头部新增一个元素

### 5.List(序列)

> 一个可以精准控制列表中每个元素的有序集合

- get(index) 获取指定位置的元素
- lastIndexOf(object) 获取指定元素的最大索引
- remove(index) 删除指定位置的元素
- set(index, obejct) 设置指定位置为新的元素
- subList(index, index) 分割列表
- sort() Java8新增, 对列表进行排序

### 6.Set

> 一个不包含重复元素的集合

### 7.SortedSet

> 一个不包含重复元素并有排列顺序的集合

- comparator() 返回结合的顺序比较器
- first() 返回集合的第一个元素, 比较器中最小的
- last() 返回集合的最后一个元素, 比较器中最大的
- headSet(object) 返回小于指定元素的集合
- subSet(object, object) 返回两个指定元素中间的集合
- tailSet(object) 返回大于指定元素的集合

## 三、集合常用实现类

### 1.LinkedList

> 实现`List`和`Deque`, 底层使用`Nodes`(链表)进行存储的集合

### 2.ArrayList

> 实现了`List`, 底层使用`Object[]`(数组)进行存储的集合

- trimToSize() 将此ArrayList集合的容量修改为列表的当前大小

![](/assets/image/blog/java-collection-theory/arraylist-trim.gif)

### 3.Vector 

> 实现了`List`, 底层使用`Object[]`(数组)进行存储的集合, 是同步的, 操作是线程安全的

### 4.HashSet

> 实现了`Set`, 底层使用的是`HashMap`

### 5.TreeSet

> 实现了`Set`, 底层使用的是`TreeMap`

## 四、Map系列

### 1.Map接口

> 键值映射关系的集合, 不包含重复的键, 一个键对应一个值

### 2.Hashtable

> 继承自`Dictionary`并实现`Map`, 底层使用的是`Entry<?,?>[]`(哈希表)

- 线程安全
- fail-fast, 如果迭代时修改集合, 会抛出异常

### 3.Properties

> 继承自`Hashtable`

- getProperty(String) 获取属性值
- setProperty(String, String)  设置属性值
- load(input) 从输入流中加载配置
- loadFromXML(input) 从xml的输入流中加载配置
- store(output, String) 保存到输出流
- storeToXML(output, String) 保存到xml的输出流

### 4.HashMap

> 继承自`AbstractMap`, 底层使用的是`Node<K,V>[]`(哈希表)

- resize() 对hash表进行扩容

### 5.LinkedHashMap

> 继承自`HashMap`, 底层使用的是`Entry<K,V>`(首尾两个节点)

### 6.TreeMap

> 继承自`AbstractMap`, 底层使用的是`Entry<K,V>`(根节点)
