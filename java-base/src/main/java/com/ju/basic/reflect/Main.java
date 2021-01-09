package com.ju.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        // 使用泛型，可以保证生成的实例不是Object对象
        Constructor<Person> single = personClass.getConstructor(String.class);
        Person singlePerson = single.newInstance("zhangsan");
        System.out.println(singlePerson.toString());

        // 使用封装类，不要使用基本类型，构造器和形参都是
        Constructor<Person> complex = personClass.getConstructor(String.class,Integer.class);
        Person complexPerson = complex.newInstance("lisi",18);
        System.out.println(complexPerson.toString());

        System.out.println("-------------------");
        System.out.println("获取方法");

        Method printPersonalInfo = personClass.getDeclaredMethod("printPersonalInfo",String.class);
        // 设置可见性 访问私有方法
        printPersonalInfo.setAccessible(true);
        Object wangwu = printPersonalInfo.invoke(singlePerson,"wangwu");
        System.out.println(wangwu);


        Method printPersonalInfo2 = personClass.getDeclaredMethod("printPersonalInfo",String.class,Integer.class);
        Object zhaoliu = printPersonalInfo2.invoke(complexPerson,"zhaoliu",19);
        System.out.println(zhaoliu);
    }
}
