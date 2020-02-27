package com.conan.reflection;

public class Test02 {
    static {
        System.out.println("Main被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 主动引用
        //   Son son= new Son();
        //反射主动引用
        //    Class.forName("com.conan.reflection.Son");

        //不会产生引用
        // 父类的静态变量
        //  System.out.println(Son.b);

        // Son[] array = new Son[5];
        //常量
        System.out.println(Son.M);

    }
}

class Father {
    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}