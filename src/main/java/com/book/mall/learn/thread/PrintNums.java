package com.book.mall.learn.thread;

/**
 * ClassName: PrintNums
 * Description:
 * date: 2020/12/26 10:27 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class PrintNums {

    private static int num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread();
            thread.start();

            System.out.println();num++;
        }
    }
}
