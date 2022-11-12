package com.proxy;

public class TxManager {

    public void before(){
        System.out.println("=================开启事务==================");
    }

    public void commit(){
        System.out.println("=================提交事务==================");
    }

}
