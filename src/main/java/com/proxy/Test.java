package com.proxy;

public class Test {

    public static void main(String[] args) {
       /* //实例化被代理对象
        BookDaoImpl bookDao = new BookDaoImpl();
        //实例化代理对象，并将被代理对象作为参数传递到代理对象中
        JDKBookProxy jdkBookProxy = new JDKBookProxy(bookDao);
        //proxy是产生的动态代理对象，动态代理可以强转为被代理对象实现的类型
        BookDao proxy = (BookDao) jdkBookProxy.getProxy();
        //此处并不是直接执行了方法，而是将调用方法作为参数传递到了invokeHandler中
        //调用方法作为Method的参数，传递到了invoke中
        proxy.selectBookByName();*/

        BookDaoImpl bookDao = new BookDaoImpl();
        CGLibBookProxy cgLibBookProxy = new CGLibBookProxy(bookDao);
        BookDaoImpl proxy = (BookDaoImpl) cgLibBookProxy.getProxy();
        proxy.selectBookByName();
    }
}
