package com.proxy;

public class BookDaoImplProxy{
    /**
     * 静态代理
     * 只能代理指定的类型
     * 本例中只对BookDao生成了代理对象
     */
    private BookDao bookDao;

    public BookDaoImplProxy(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public String selectBookByName() {
        before();
        bookDao.selectBookByName();
        after();
        return null;
    }

    public void before(){
        System.out.println("==================打开系统===============");
    }

    public void after(){
        System.out.println("==================关闭系统===============");
    }

}
