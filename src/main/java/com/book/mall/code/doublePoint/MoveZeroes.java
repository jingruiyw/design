package com.book.mall.code.doublePoint;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: MoveZeroes
 * Description:
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * date: 2020/8/1 1:57 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class MoveZeroes {

    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,0,3,12};
//        int[] nums = new int[]{0};
        int[] nums = new int[]{0, 1, 1, 0};
        moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    /**
     * 3.双指针，一个用来记录0开始的位置(个数)，一个用来遍历
     * 需要两次遍历
     * @param nums
     */
    private static void moveZeroesV3(int[] nums) {
        int beginZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[++beginZero] = nums[i];
            }
        }

        //把0个数之后的位置都换成0
        for (int i = beginZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 2.双指针快排思想
     * a用来遍历，b用来检测为0的值
     * a遇到非0的值就与b交换
     *
     * @param nums
     */
    private static void moveZeroesV2(int[] nums) {
        int b = 0;
        for (int a = 0; a < nums.length; a++) {
            if (nums[a] != 0) {
                int temp;
                temp = nums[a];
                nums[a] = nums[b];
                nums[b++] = temp;
            }
        }
    }


    /**
     * 1.双指针。自己想的，s和遇到的非0p交换
     *
     * @param nums
     */
    private static void moveZeroes(int[] nums) {
        int s = 0;
        for (int p = 1; p < nums.length; p++) {
            if (nums[s] == 0 && nums[p] != 0) {
                nums[s] = nums[p];
                nums[p] = 0;
                s++;
            } else if (nums[s] != 0) {
                s++;
            }
        }

        //处理最后一个数
        if (nums[s] == 0 && nums[nums.length - 1] != 0) {
            nums[s] = nums[nums.length - 1];
            nums[nums.length - 1] = 0;
        }
    }
}
