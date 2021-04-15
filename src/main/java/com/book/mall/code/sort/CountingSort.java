package com.book.mall.code.sort;


import java.util.Arrays;

/**
 * ClassName: CountingSort
 * Description:
 * 计数排序: 稳定排序
 * 典型的空间换时间
 * date: 2021/2/15 5:52 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = {9, 4, 6, 2, 7, 3, 1, 4};
        // res : [1, 2, 3, 4, 4, 6, 7, 9]
        System.out.println(Arrays.toString(countingSort(array)));
    }

    /**
     * 计数排序代码实现
     * space:o(n + k) k是整数的取值范围
     * time:o(n + k)
     *
     * @param arr
     */
    private static int[] countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        //找出数组的最值
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        //开辟存储空间，存储每个整数是在数组中的第几个数
        //存储个数为数组中元素的种类，前闭后闭，故需要加1
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            //统计出现次数
            count[arr[i] - min]++;
        }
        //累加次数：从索引1开始，把前面的次数加上自己
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //开辟新的数组
        int[] res = new int[arr.length];
        //从arr后面往前遍历元素，拿到具体元素的位置
        for (int i = arr.length - 1; i >= 0; i--) {
            res[--count[arr[i] - min]] = arr[i];
        }
        return res;
    }
}













































