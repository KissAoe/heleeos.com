---
title: 常见的排序算法
thumbnail: 'https://picsum.photos/300/200?random=7'
info: ''
recent: false
date: 2017-03-31 14:21:39
url:
category:
tags:
---

## 一、排序算法的理论和总结

> 学习基本的排序算法可以提高逻辑思维能力

算法中常见的术语有: 

- **时间复杂度**: 要通过多少次计算才能解决问题, 一般来说, 好的性能是**O**(*n*log*n*)，差的性能是**O**(n<sup>2</sup>)
- **空间复杂度**: 需要多少额外的内存, 一般来说, 空间复杂度越小, 算法越好
- **稳定性**: 当有两个相等的元素*A*和*B*, 原来的列表中*A*出现在*B*之前, 排序过后的列表*A*还是出现在*B*之前

### 排序算法简单比较

|排序方法|数据对象|平均情况|最好情况|最坏情况|空间复杂度|稳定性|
|:-------|:-------|:-------|:-------|:-------|:---------|:-----|
|冒泡排序|数组|**O**(n<sup>2</sup>)|**O**(n)|**O**(n<sup>2</sup>)|**O**(1)|稳定|
|选择排序|数组, 链表|**O**(n<sup>2</sup>)|**O**(n<sup>2</sup>)|**O**(n<sup>2</sup>)|**O**(1)|稳定|
|插入排序|数组, 链表|**O**(n<sup>2</sup>)|**O**(n)|**O**(n<sup>2</sup>)|**O**(1)|稳定|
|希尔排序|数组|**O**(*n*log*n*) ~ **O**(n<sup>2</sup>)|**O**(*n*log*n*)|**O**(n<sup>2</sup>)|**O**(1)|不稳定|
|堆排序  |数组|**O**(*n*log*n*)|**O**(*n*log*n*)|**O**(*n*log*n*)|**O**(1)|不稳定|
|归并排序|数组, 链表|**O**(*n*log*n*)|**O**(*n*log*n*)|**O**(*n*log*n*)|**O**(n)|稳定|
|快速排序|数组|**O**(*n*log*n*)|**O**(*n*log*n*)|**O* (n<sup>2</sup>)|**O**(*log*n) ~ **O**(n)|不稳定|

## 二、排序算法介绍

### 1.冒泡排序

**冒泡排序**的大概步骤

1. 比较相邻的元素, 如果第一个比第二个大, 就交换他们两个
2. 从开始第一对到未排序的最后一对
3. 对所有的元素重复以上的步骤, 直到没有任何变化为止

**冒泡排序**的伪码

```
for(i from 0 to length-1)
    for(j from 0 to length-i-1)
        if (array[j] > array[j + 1])
            swap(array[j], array[j + 1])
```

![](https://upload.wikimedia.org/wikipedia/commons/3/37/Bubble_sort_animation.gif)
动图为*冒泡排序的过程*, 引用自[维基百科](https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F)

[Java代码实现](https://github.com/greenfit/Learn/blob/master/SortingAlgorithm/src/java/BubbleSort.java)

### 2.选择排序

**选择排序**的大概步骤

1. 从未排序元素中选出最小的, 和未排序的第一个元素进行替换
2. 对所有的元素重复以上步骤

**选择排序**的伪码

```
for(i from 0 to length-1)
	index = i
	for(j from i+1 to length-1)
		if(array[j] < array[i])
			index = j
	swap(array[i], array[index])
```

![](https://upload.wikimedia.org/wikipedia/commons/b/b0/Selection_sort_animation.gif)
动图为*选择排序的过程*, 引用自[维基百科](https://zh.wikipedia.org/wiki/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F)

[Java代码实现](https://github.com/greenfit/Learn/blob/master/SortingAlgorithm/src/java/SelectionSort.java)

### 3.插入排序

**插入排序**的大概步骤

1. 取出当前的元素作为基准, 与前一个比较
2. 如果前一个元素大, 则将前一个元素后移, 继续比较
3. 如果前一个元素小, 则将基准元素插入到当前位置
4. 对每一个元素重复以上过程

**插入排序**的伪码

```
for(i from 1 to length-1)
    temp = array[i]
    for(j from i-1 to 0)
        if(temp < array[j])
            array[j + 1] = array[j]
            if(j == 0)
                array[0] = temp
        else
            array[j + 1] = temp
            break;
```

![](https://upload.wikimedia.org/wikipedia/commons/2/25/Insertion_sort_animation.gif)
动图为*插入排序的过程*, 引用自[维基百科](https://zh.wikipedia.org/wiki/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F)

[Java代码实现](https://github.com/greenfit/Learn/blob/master/SortingAlgorithm/src/java/InsertionSort.java)

### 4.希尔排序

**希尔排序**的大概步骤

1.按步长对元素分组
2.对每一个元素进行插入排序
3.直到步长为1, 进行最后一次插入排序

**希尔排序**的伪码

```
for(gap from length >> 1 to 1, gap = gap >> 1) 
	for(i from gap to length)
	    temp = array[i]
	    for(j from i-gap to 0, j -= gap)
	        if(temp < array[j])
	            array[j + gap] = array[j]
	        else
	            break;
	    array[j + gap] = temp
```

![](https://upload.wikimedia.org/wikipedia/commons/d/d8/Sorting_shellsort_anim.gif)
动图为*希尔排序的过程*, 引用自[维基百科](https://zh.wikipedia.org/wiki/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F)

[Java代码实现](https://github.com/greenfit/Learn/blob/master/SortingAlgorithm/src/java/ShellSort.java)

### 5.堆排序

**堆排序**的大概步骤


**堆排序**的伪码

```

```

![](https://upload.wikimedia.org/wikipedia/commons/1/1b/Sorting_heapsort_anim.gif)
动图为*堆排序的过程*, 引用自[维基百科](https://zh.wikipedia.org/wiki/%E5%A0%86%E6%8E%92%E5%BA%8F)

[Java代码实现](https://github.com/greenfit/Learn/blob/master/SortingAlgorithm/src/java/HeapSort.java)

### 6.归并排序

**归并排序**的大概步骤


**归并排序**的伪码

```

```

![](https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Merge_sort_animation2.gif/220px-Merge_sort_animation2.gif)
动图为*归并排序的过程*, 引用自[维基百科](https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F)

[Java代码实现](https://github.com/greenfit/Learn/blob/master/SortingAlgorithm/src/java/MergeSort.java)

### 7.快速排序

**快速排序**的大概步骤

1. 选择一个基准
2. 小于基准的和大于基准的相互交换
3. 基准数的左边进行一次排序
4. 基准数的右边进行一次排序

**快速排序**的伪码

```
function quickSort(array, start, end)
    number = array[end]
    while(left < right)
        while(array[left] < number && left < right) left++
        while(array[right] > number && left < right) right++
        swap(array, left, right)
    quickSort(array, start, left - 1)
    quickSort(array, left + 1, end)
```

![](https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif)
动图为*快速排序的过程*, 引用自[维基百科](https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F)

[Java代码实现](https://github.com/greenfit/Learn/blob/master/SortingAlgorithm/src/java/QuickSort.java)
