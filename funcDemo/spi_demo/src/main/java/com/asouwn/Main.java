package com.asouwn;

import java.io.IOException;

import com.asouwn.inter.Interface;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        /**
         * 这段代码一般在工厂模式下运行
         */
        SpiLoader.loda(Interface.class);

        Interface A = SpiLoader.getInstance(Interface.class, "A");
        Interface B = SpiLoader.getInstance(Interface.class, "B");
        System.out.println("class instance A.getName " + A.getName());
        System.out.println("class instance B.getName " + B.getName());
    }
}