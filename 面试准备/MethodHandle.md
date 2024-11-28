# MethodHandle

又叫`现代化反射`，与传统反射相比，methodhandle更接近底层代码，他可以省略掉许多重复的安全检查，并且可以被jvm优化为内联代码，直接指向底层方法的的句柄，调用路径更短，所以性能更好。

|方法|描述|常用场景
|-|-|-|
findVirtual|查找实例方法|调用普通实例方法
findStatic|	查找静态方法|调用静态方法
findConstructor|查找构造方法|动态创建对象
findSpecial|查找特殊方法（父类方法/私有方法）|父类方法或特定类实现调用
findGetter|查找字段 getter|获取字段值
findSetter|查找字段 setter|修改字段值
unreflect|将反射对象转为 MethodHandle|已有反射对象优化调用
bind|将方法绑定到特定实例|简化特定实例的调用