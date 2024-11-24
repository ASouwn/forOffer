# demo中用到的相关类面试考点
### ConcurrentHashMap
[传送门](https://www.bilibili.com/video/BV1rp4y1P7ci/?spm_id_from=333.337.search-card.all.click&vd_source=577abed59998ef663e52bdc0a55aa8af)

`HashMap`在多线程环境下扩容会出现CPU接近 100% 的情况，因为`HashMap`并不是线程安全的, `ConcurrentHashMap` 就是线程安全的 map，

在`Jdk 1.7中`其中利用了`锁分段的思想`大大提高了并发的效率。整个哈希表被分为多个段，每个段都独立锁定。`读取操作不需要锁`，写入操作仅锁定相关的段。这减小了锁冲突的几率，从而提高了并发性能。

而在`Jdk 1.8中`，`ConcurrentHashMap`的实现方式发生了改变，不再使用分段锁，而是使用了 CAS+synchronized 来保证并发安全。
