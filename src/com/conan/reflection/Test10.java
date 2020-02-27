package com.conan.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test10 {

    //normal
    public static void test01(){
        User user= new User();
        long startTime =System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime =System.currentTimeMillis();
        System.out.println("normal time is : "+(endTime-startTime)+" ms");
    }


    //reflection
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user= new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime =System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime =System.currentTimeMillis();
        System.out.println("reflection time is : "+(endTime-startTime)+" ms");
    }

    //reflection 关闭检测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user= new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);

        long startTime =System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime =System.currentTimeMillis();
        System.out.println("reflection no access time is : "+(endTime-startTime)+" ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
