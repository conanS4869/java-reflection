package com.conan.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.conan.reflection.User");

        //构造一个对象
      //  User user = (User) c1.newInstance();

        //通过构造器创建普通对象
        Constructor constructor = c1.getDeclaredConstructor(int.class, String.class, int.class);
        User user2 = (User) constructor.newInstance(1, "conan", 30);
        System.out.println(user2);

        //通过反射构造方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke 激活
         setName.invoke(user3, "sherry");
        System.out.println(user3.getName());

        //反射构着属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //关掉安全检测,不能直接操作私有属性
        name.setAccessible(true);
        name.set(user4, "9999");
        System.out.println(user4.getName());

    }
}
