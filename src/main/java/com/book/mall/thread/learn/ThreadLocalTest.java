package com.book.mall.thread.learn;

/**
 * ClassName: ThreadLocalTest
 * Description:
 * date: 2020/1/30 10:24 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ThreadLocalTest {

    private volatile int num;

    public void method() {

        ThreadLocal threadLocal = new ThreadLocal();
        System.out.println("添加测试合并commit");
        System.out.println("添加测试合并commit01");
        System.out.println("添加测试合并commit01");
    }
}
