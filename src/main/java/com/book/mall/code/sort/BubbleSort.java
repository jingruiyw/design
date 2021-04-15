package com.book.mall.code.sort;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: BubbleSort
 * Description:
 * 冒泡排序：两次循环遍历，使得最大/最小的数字向数组一侧移动
 * 稳定
 * time:o(n^2)
 * date: 2021/2/15 12:52 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] array = {9, 4, 6, 2, 7, 3, 1, 4};
        //[1,2,3,4,4,6,7,9]
        System.out.println(JSON.toJSON(sort(array)));
    }


    /**
     * 冒泡排序
     *
     * @param array
     */
    private static int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}



















































