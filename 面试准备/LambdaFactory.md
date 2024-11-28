# LambdaFactory
主要是为了减少lambda表达式的创建开销，减少GC

## 实现细节(Supplier类)
这个类只有一个抽象方法，可以被隐式转换成lambda表达式，或者用`@FunctionalInterface`注解，用于标识一个接口是函数式接口

~~~java
@FunctionalInterface
public interface MyFunction {
    int apply(int x);
}

public class Main {
    public static void main(String[] args) {
        MyFunction func = (x) -> x * x;
        System.out.println(func.apply(5)); // 输出 25
    }
}
~~~