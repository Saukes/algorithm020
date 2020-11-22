## 学习笔记

### Queue源码分析：
Queue接口定义的是一个队列，它包含了队列的基本操作入队和出队。
Queue接口定义了6个方法：
boolean add(E e);
boolean offer(E e);
E remove();
E poll();
E element();
E peek();
根据操作可以分为三类：入队、出队和遍历。
1、入队：add()和offer()
二者区别在于：当队列空间已经无满无法入队时，add()方法会抛出异常；而offer()会返回false。
2、出队：remove()和poll()
二者区别在于：当队列为空时，remove()方法会抛出异常；而poll()会返回null。
3、遍历：element()和peek()
element()和peek()都表示检索但不移除队列头部元素，可用于从头开始遍历队列。
二者区别在于：当队列为空时，element()方法会抛出异常，而peek()会返回null。

### PriorityQueue源码分析：
PriorityQueue底层是一个用数组实现的完全二叉树，但它并不只是一个完全二叉树，
在没有自定义比较器（自然排序）的情况下，更严格的来讲它是一个基于数组实现的小顶堆（父节点的元素值小于左右孩子节点的元素值）。
相关属性：
// 优先队列的默认初始大小是 11
private static final int DEFAULT_INITIAL_CAPACITY = 11;
// 底层是一个 Object 数组
transient Object[] queue;
// 优先队列中的元素个数
private int size = 0;
// 最大容量限制
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
扩容机制：
当 queue 的长度小于 64 时，它每次扩容都是比原来大一倍且再多扩充两个存储单位；
而当 queue 的长度大于等于 64 之后，它每次扩容都是比原来多扩50%的空间。
添加元素：
在往 PriorityQueue 里添加元素的时候，每次都默认添加到队尾去，然后一直与父节点进行比较，
判断是否需要调整节点的值，直至使它满足大顶堆（或小顶堆）的性质。
删除元素：
PriorityQueue 删除元素有两种方法，一种是获取并删除堆顶元素，另外一种是删除指定元素。
获取并删除堆顶元素：
获取堆顶元素很简单，直接取 queue[0] 就可以了，但是删除了堆顶元素之后，此时就需要对堆的结构进行调整，重新选举出一个堆顶。
删除指定元素：很容易想到，对于一个这种结构的容器来说，删除指定元素免不了需要对整个数组进行遍历。

### 学习总结
一、三分看视频理解，七分练习
二、不死磕，对于无法理解的代码，先死记硬背代码，勇于看高手代码
三、最重要的是要过遍数
