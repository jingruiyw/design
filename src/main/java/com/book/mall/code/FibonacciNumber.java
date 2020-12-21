package com.book.mall.code;

/**
 * ClassName: FibonacciNumber
 * Description:
 * date: 2020/12/19 1:20 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class FibonacciNumber {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fib(i) + ",");
        }
    }

    /**
     * 递归实现
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
