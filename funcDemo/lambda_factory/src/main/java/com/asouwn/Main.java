package com.asouwn;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Interface a = LambdaFactory.getInstance();
        System.out.println(a.get());
    }
}