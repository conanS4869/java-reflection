package com.conan.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 */
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.conan.reflection.Student");
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获取注解的value
        TableConan tableConan = (TableConan) c1.getAnnotation(TableConan.class);
        String value = tableConan.value();
        System.out.println(value);
        //  获取类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldConan annotation = f.getAnnotation(FieldConan.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@TableConan("db_student")
class Student {
    @FieldConan(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldConan(columnName = "db_name", type = "varchar", length = 10)
    private String name;
    @FieldConan(columnName = "db_age", type = "int", length = 10)
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableConan {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldConan {
    String columnName();

    String type();

    int length();
}
