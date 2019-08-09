---
title: test
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-04-12 14:12:32
url:
category:
tags:
---

## Hashtable 和 HashMap 区别

### 1.put区别

Hashtable的put流程

1. value非null
2. hash, key相同, 新值替换旧值,返回旧值
3. 新实体(Entry)的 next 挂上旧实体(Entry)
4. table 中对应的 index 存储新实体

HashMap的put流程

1. 是否需要 resize()
2. 如果对应位置为 null, table 对应位置为新的Node
3. 找出当前的 key 对应的节点(Node)
4. 如果 key 不一样, 那就在现有的节点中, 找出最后一个, 并新建一个节点(Node)
5. 新值替换旧值, 返回旧值

### 2.hash区别

Hashtable的hash算法

目的是为了保证算出的hash值是非负数

1. hash = key.hashCode();
2. hash = hash & 0x7FFFFFFF;

HashMap的hash算法

目的是为了减少冲突, 同时速度和性能没有太大的影响

1. hash = key.hashCode();
2. hash = hash ^ (hash >>> 16);