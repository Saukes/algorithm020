## 学习笔记

### 位运算

### 布隆过滤器

一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索 一个元素是否在一个集合中。 优点：空间效率和查询时间都远远超过一般的算法。 缺点：有一定的误识别率和删除困难。

### LRU缓存

```java
public class LRUCache {

    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        int maximumCapacity;

        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }
}
```

### 排序算法

1. 比较类排序:通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。

2. 非比较类排序:不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

### 初级排序-O(n^2)

1. 选择排序（Selection Sort）:每次找最小值，然后放到待排序数组的起始位置。
2. 插入排序（Insertion Sort）:从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后 向前扫描，找到相应位置并插入。
3. 冒泡排序（Bubble Sort）:嵌套循环，每次查看相邻的元素如果逆序，则交换。

### 高级排序 - O(N*LogN)

#### 快速排序（Quick Sort）

归并：先排序左右子数组，然后合并两个有序子数组 数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依 次对右边和右边的子数组继续快排；以达到整个序列有序。

#### 归并排序（Merge Sort）— 分治

快排：先调配出左右子数组，然后对于左右子数组进行排序

1. 把长度为n的输入序列分成两个长度为n/2的子序列；
2. 对这两个子序列分别采用归并排序；
3. 将两个排序好的子序列合并成一个最终的排序序列。

#### 堆排序（Heap Sort）

堆插入 O(logN)，取最大/小值 O(1)

1. 数组元素依次建立小顶堆
2. 依次取堆顶元素，并删除

### 特殊排序 - O(n)

* 计数排序（Counting Sort） 计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存 储在额外开辟的数组空间中；然后依次把计数大于 1 的填充回原数组
* 桶排序（Bucket Sort） 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到 有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方 式继续使用桶排序进行排）。
* 基数排序（Radix Sort） 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类 推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按 高优先级排序。
