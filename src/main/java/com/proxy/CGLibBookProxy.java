package com.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibBookProxy implements MethodInterceptor {

    private Object object;

    public CGLibBookProxy(Object object) {
        this.object = object;
    }

    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object returnValue = method.invoke(object,objects);
        after();
        return returnValue;
    }

    public void before(){
        System.out.println("=================开启事务==================");
    }

    public void after(){
        System.out.println("=================关闭事务==================");
    }
}
