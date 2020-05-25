package com.book.mall.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: 【1】TowSum
 * Description:
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * date: 2020/5/21 2:01 上午
 * TODO 【1】学习一下HashMap底层实现原理
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class TowSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 7};
        System.out.println(JSON.toJSONString(twoSumSort(nums, 10)));
    }

    /**
     * 1.非有序数组，hashMap解法，支持数组元素重复
     * time：O(n)
     * space：O(n)
     */
    public static int[] twoSum(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0) {
            return new int[2];
        }

        for (int i = 0; i < nums.length; i++) {
            int des = target - nums[i];
            if (map.containsKey(des)) {
                return new int[]{map.get(des), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new Exception("Array Error");
    }

    /**
     * 有序数组
     * 时间：O(n)
     * 空间：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumSort(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[2];
    }
}
