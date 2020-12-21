package com.book.mall.learn.juc;

import org.junit.Test;

/**
 * ClassName: ThreadInteruptDemoTest
 * Description:
 * date: 2020/12/21 9:39 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ThreadInterruptDemoTest {

    /**
     * 测试ReentrantLock响应中断
     *
     * @throws Exception
     */
    @Test
    public void exeInterruptTest() throws Exception {
        ThreadInteruptDemo demo = new ThreadInteruptDemo();
        demo.exeInterrupt();
    }

    /**
     * 测试Synchronized响应中断
     *
     * @throws Exception
     */
    @Test
    public void exeInterruptSynTest() throws Exception {
        ThreadInteruptDemo demo = new ThreadInteruptDemo();
        demo.exeInterruptSyn();

    }
}
