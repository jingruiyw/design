package com.book.mall.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ThreadTest
 * Description:
 * date: 2021/6/7 2:08 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ThreadTest {

    private static volatile Integer num = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition con = lock.newCondition();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                System.out.println(Thread.currentThread() + String.valueOf(num));
                con.signal();
                num++;
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                System.out.println(Thread.currentThread() + String.valueOf(num));
                con.signal();
                num++;
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        t3.start();
        t4.start();

//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (lock) {
//                    System.out.println(Thread.currentThread() + String.valueOf(num));
//                    num++;
//                    lock.notify();
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (lock) {
//                    System.out.println(Thread.currentThread() + String.valueOf(num));
//                    num++;
//                    lock.notify();
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//        t2.start();
    }
}
