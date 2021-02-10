package com.book.mall.code.doublePoint;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * ClassName: SquaresOfASortedArray
 * Description:
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * date: 2021/2/10 6:44 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class SquaresOfASortedArray {


    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
//        int[] nums = {-1};
//        System.out.println(JSON.toJSON(sortedSquares(nums)));
//        System.out.println(JSON.toJSON(sortedSquares2(nums)));
        System.out.println(JSON.toJSON(sortedSquares3(nums)));
    }

    /**
     * 1. 直接取平方，然后再排序数组
     * time:o(nlogn)
     * space:o(logn)
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        //默认升序
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针
     * 1.找到正负中间的数，左右分别比较
     * 2.再将正确的结果放入数组中
     * time:o(n)
     * space:o(1) 表示非返回值之外所用的空间
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int edge = -1;
        //找到正负分界线
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                edge = i;
            } else {
                //减少不必要的循环循环
                break;
            }
        }
        int[] ans = new int[nums.length];
        int idx = 0;
        int p1 = edge;
        int p2 = edge + 1;
        //条件是符合的进去循环
        while (p1 >= 0 || p2 < nums.length) {
            if (p1 < 0) {
                //左边结束
                ans[idx] = nums[p2] * nums[p2];
                p2++;
            } else if (p2 == nums.length) {
                //右边结束
                ans[idx] = nums[p1] * nums[p1];
                p1--;
            } else if (nums[p1] * nums[p1] < nums[p2] * nums[p2]) {
                ans[idx] = nums[p1] * nums[p1];
                p1--;
            } else {
                ans[idx] = nums[p2] * nums[p2];
                p2++;
            }
            idx++;
        }
        return ans;
    }

    /**
     * 3.双指针
     * 采用两头往中间移动的策略
     * time:o(n)
     * time:o(1)
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] ans = new int[nums.length];
        int p1 = 0;
        int p2 = nums.length - 1;
        int idx = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] * nums[p1] < nums[p2] * nums[p2]) {
                ans[idx] = nums[p2] * nums[p2];
                p2--;
            } else {
                ans[idx] = nums[p1] * nums[p1];
                p1++;
            }
            idx--;
        }
        return ans;
    }
}




































