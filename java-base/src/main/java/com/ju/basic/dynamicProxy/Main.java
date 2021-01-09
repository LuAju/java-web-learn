package com.ju.basic.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        // 被代理对象
        SuperMan superMan = new SuperMan();
        // 根据工厂生成代理对象
        Human proxyInstace =(Human) ProxyFacroty.getProxyInstace(superMan);
        proxyInstace.eat("汉堡");
    }
}


interface Human{
    String getBelief();

    void eat(String food);
}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return " i am the superman";
    }

    @Override
    public void eat(String food) {
        System.out.println(" i like eating" +food);
    }
}

// 代理对象
// 1. 如何根据被代理对象，生成代理对象 -----> 使用代理工厂
// 2. 执行代理方法时，如何执行被代理的方法 ---> 实现InvocationHandler接口

class ProxyFacroty{
    // 形参是被代理对象，因为要根据被代理对象生成代理对象
    public static Object getProxyInstace(Object object){


        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(object);

        // 根据被代理对象生成代理对象
        return Proxy.newProxyInstance(
                // 需要执行被代理对象的类加载器，保持一致
                object.getClass().getClassLoader(),
                // 保证所有的接口一致性
                object.getClass().getInterfaces(),

                // 定义代理类执行时，如何实现被代理方法
                myInvocationHandler
        );
    }
}

// 定义如何执行代理方法的时候，执行
class MyInvocationHandler implements InvocationHandler{

    // 被代理的对象，因为invoke方法执行时无法获取被代理对象（形参内没有），所以这里设置
    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    // // 当我们调用代理类的方法，就会自动执行invoke方法
    @Override
    // proxy是代理对象，method就是当前被执行的方法，
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行代理类的方法，因为代理对象和被代理对象实现了相同接口，因此他们的对象应该也是同一个

        Object returnValue = method.invoke(object, args);

        // 定义增强的方法
        System.out.println("时间："+ new Timestamp(System.currentTimeMillis()));
        return returnValue;
    }
}



