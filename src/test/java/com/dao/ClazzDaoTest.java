package com.dao;

import com.pojo.Clazz;
import com.utils.MybatisUtil;
import junit.framework.TestCase;

public class ClazzDaoTest extends TestCase {

    public void testQueryClazzTest() {
        ClazzDao clazzDao = MybatisUtil.getMapper(ClazzDao.class);
        Clazz clazz = clazzDao.queryClazz(1);
        System.out.println(clazz);
    }
}