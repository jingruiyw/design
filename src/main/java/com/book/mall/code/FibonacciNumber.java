package com.book.mall.code;

/**
 * ClassName: FibonacciNumber
 * Description:
 * 509. 斐波那契数
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

    /**
     * 循环实现
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        while (n >= 1) {
            int temp = first + second;
            first = second;
            second = temp;
            n--;
        }
        return first;
    }

    /**
     * 循环
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        int first = 0;
        int second = 1;
        while (n > 0) {
            int temp = first + second;
            first = second;
            second = temp;
            n--;
        }
        return first;
    }
}























