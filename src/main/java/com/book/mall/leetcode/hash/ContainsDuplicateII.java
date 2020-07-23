package com.book.mall.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ContainsDuplicateII
 * Description:
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * date: 2020/7/22 11:46 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1, 2, 3};
        int[] nums = {1, 0, 1, 1};
//        int k = 2;
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    /**
     * 1.用散列表表示滑动窗口值
     * 也可以用一个set只存储k个值，遍历数组，set中有就return true; 没有则添加一个，然后移除k个最早的值；
     *
     * @param nums
     * @param k
     * @return
     */
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null) {
                if (i - index <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 错误解法：差值的绝对值只能等于k时可以这么写
     *
     * @param nums
     * @param k
     * @return
     */
    private static boolean containsNearbyDuplicateV1(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }

        int slow = 0;
        int fast = k;
        while (slow < nums.length && fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                return true;
            } else {
                slow++;
                fast++;
            }
        }
        return false;
    }
}
