package com.book.mall.code.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * ClassName: HeapSort
 * Description:
 * 堆排序
 * 不稳定
 * date: 2021/2/15 1:56 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {9, 4, 6, 2, 7, 3, 1, 4};
//        int[] array = {9, 4, 6};
        heapSort2(array);
        //[1,2,3,4,4,6,7,9]
        System.out.println(JSON.toJSON(array));
    }

    public static void heapSort2(int[] arr) {
        //1.将无序堆调整为大顶堆
        for (int i = arr.length / 2; i <= 0; i--) {
            downAdjust(arr, i, arr.length - 1);
        }
        System.out.println(Arrays.toString(arr));
        //2.循环删除栈顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = arr.length - 1; i > 0; i--) {
            //最后一个元素和第一个进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //下沉调整最大堆
            downAdjust(arr, 0, i);
        }
    }

    /**
     * 下沉调整
     *
     * @param arr
     * @param root   父节点下标
     * @param length 堆的有效大小
     */
    private static void downAdjust(int[] arr, int root, int length) {
        //temp 暂存父节点
        int temp = arr[root];
        //拿到左孩子
        int child = 2 * root + 1;
        while (child < length) {
            //如果有右孩子且右孩子比左孩子值大
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }
            //如果父节点小于任何一个孩子的值，将子节点赋值给父节点
            if (temp >= arr[child]) {
                break;
            }
            arr[root] = arr[child];
            root = child;
            child = 2 * root + 1;
        }
        //无需每步都交换，只需要交换最终的值
        arr[root] = temp;
    }

    /**
     * 1
     *
     * @param arr
     * @param length
     */
    public static void heapSort(int[] arr, int length) {
        //
        for (int i = (length - 1) / 2; i >= 0; i--) {
            sort(arr, i, length);
        }
    }

    /**
     * @param arr
     * @param root   根节点下标
     * @param length 堆的长度
     */
    private static void sort(int[] arr, int root, int length) {
        if (root > length) {
            return;
        }
        //求父节点的左右孩子
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int max = arr[root];
        //分别判断左右节点与当前父节点的大小
        if (right < length && max < arr[right]) {
            max = arr[right];
        }
        if (left < length && max < arr[left]) {
            max = arr[left];
        }
        //判断max是否与子节点交换
        if (max != arr[root]) {
            //如果交换了，需要变更节点数据,先找出max是与那个子节点交换
            if (left < length && max == arr[left]) {
                arr[left] = arr[root];
                //把当前节点当做根节点继续遍历
                sort(arr, left, length);
            }
            if (right < length && max == arr[right]) {
                arr[right] = arr[root];
                //把当前节点当做根节点继续遍历
                sort(arr, right, length);
            }
            arr[root] = max;
        }
    }
}



































