# java排序相关类与方法

## 两种排序的方式（区别排序的对象选择）
- Dual-Pivot Quicksort 用于原始类型数组，提供了快速和高效的排序。
这是一种改进的快速排序算法，在大多数情况下比传统的单轴快速排序更快。它由 Vladimir Yaroslavskiy 设计并实现，被引入到 Java 7 中。
Dual-Pivot Quicksort 使用两个枢轴元素，将数组分为三个部分进行排序，这样可以减少比较次数，提高排序速度。
- Timsort 用于对象类型数组，擅长处理部分有序的数据，并具有稳定排序的特性。
这是一种混合排序算法，结合了归并排序和插入排序的优点。它在合并部分已经排序的数组时非常高效，这使它在处理实际应用中的数据（通常部分有序）时表现良好。
Timsort 由 Tim Peters 为 Python 设计并实现，也被 Java 和其他语言所采用。它在 Java 中的实现于 Java 7 引入。
## 可以直接调用的方法
### Arrays.sort()
- 对原始类型数组(int[], char[])：使用 Dual-Pivot Quicksort 算法。
- 对对象类型数组(Integer[], String[])：使用 Timsort 算法。

### Collections.sort()
Collections 类提供了一个 sort 方法，用于对 List 进行排序。Collections.sort() 方法使用 Timsort 算法。

### Stream.sorted()
Stream API 提供了 sorted 方法，用于对流中的元素进行排序。它可以使用自然顺序或自定义比较器进行排序。
~~~java
List<String> stringList = Arrays.asList("banana", "apple", "cherry");
List<String> sortedList = stringList.stream().sorted("<可以选择用自定义比较器>").collect(Collectors.toList());
System.out.println(sortedList); // 输出 [apple, banana, cherry]
~~~

## 与排序相关的类
### PriorityQueue
    堆， 默认为最小堆 时间复杂度为 n log n
### TreeMap
    内部用红黑树排序 时间复杂度为 n log n
### LinkedHashMap
    这个可以用于维持插入顺序或者访问顺序
### ConcurrentSkipListMap
    内部使用 跳表 来维持元素的顺序。
### TreeSet
    内部用红黑树排序 时间复杂度为 n log n
### ConcurrentSkipListSet
    内部使用 跳表 来维持元素的顺序。
### LinkedList
    这个可以用于维持插入顺序或者访问顺序