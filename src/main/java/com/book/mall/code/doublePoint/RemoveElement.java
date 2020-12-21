package com.book.mall.code.doublePoint;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: RemoveElement
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * Description:
 * date: 2020/7/31 12:38 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int val = 2;
        int[] nums = {3, 2, 2, 3};
        int val = 3;

//        int[] nums = {3, 3};
//        int val = 5;
        System.out.println(removeElement(nums, val));
    }

    /**
     * 当我们遇到 nums[i] = valnums[i]=val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。
     *
     * @param nums
     * @param val
     * @return
     */
    private static int removeElementV2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    /**
     * 1.双指针，一个指数，一个遍历
     *
     * @param nums
     * @param val
     * @return
     */
    private static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        System.out.println(JSON.toJSONString(nums));
        return slow;
    }
}






























