package com.asouwn;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Main {
    public static void main(String[] args) throws Throwable {

        A a = new A();
        // 查找工具
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        // 定义方法签名，返回类型为String，无接收参数
        MethodType methodType = MethodType.methodType(String.class);
        MethodHandle methodHandle = lookup.findVirtual(A.class, "getName", methodType);

        System.out.println((String) methodHandle.invoke(a));

    }
}