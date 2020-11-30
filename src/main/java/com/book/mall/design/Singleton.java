package com.book.mall.design;

/**
 * ClassName: Singleton
 * Description:
 * date: 2020/12/1 12:25 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class Singleton {

    //可以保证singleton读取的都是最新的值
    private static volatile Singleton singleton;

    //私有化构造方法
    private Singleton() {
    }

    /**
     * 第一种：双重检查
     *
     * @return
     */
    //对外提供静态获取实例的方法
    public static Singleton getInstance() {
        //一重检查为了提高效率
        if (singleton == null) {
            synchronized (Singleton.class) {
                //二层检查为了避免重复获取对象
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }


    private static class SingletonInstance {
        private static Singleton singleton = new Singleton();
    }

    /**
     * 2.内部静态类
     *
     * @return
     */
    public static Singleton getTarget() {
        return SingletonInstance.singleton;
    }
}
