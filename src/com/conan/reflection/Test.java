package com.conan.reflection;

public class Test {
    public static void main(String[] args) {
        A a= new A();
        System.out.println(A.m);
    }
}

class A{
    static {
        System.out.println("静态代码块初始");
        m=300;
    }
    static int m =100;

    public A() {
        System.out.println("A类的无参构造");
    }
}
