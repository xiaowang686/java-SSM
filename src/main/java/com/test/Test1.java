package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {

    public static void main(String[] args) throws Exception {
        String classPath = "com.pojo.Student";

        Class<?> c = Class.forName(classPath);

        Object instance = c.newInstance();

        Field[] fields = c.getDeclaredFields();

        for (Field field:fields) {
            String fieldName = field.getName();//stuId
            String setMethodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
            if ("setStuId".equals(setMethodName)){
                Method method = c.getDeclaredMethod(setMethodName, field.getType());
                method.invoke(instance,"10001");
            }
        }
        System.out.println(instance);
    }
}
