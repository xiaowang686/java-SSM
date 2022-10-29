package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKBookProxy implements InvocationHandler {
    /**
     动态代理
     本例为JDK动态代理
     JDK动态代理可以为实现了接口类型的任意类产生代理对象
     */
    private Object object;

    public JDKBookProxy(Object object) {
        this.object = object;
    }

    public Object getProxy(){
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        Object o = Proxy.newProxyInstance(classLoader, interfaces, this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(object, args);
        after();
        return result;
    }

    public void before(){
        System.out.println("==================打开系统===============");
    }

    public void after(){
        System.out.println("==================关闭系统===============");
    }

}
