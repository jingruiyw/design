package com.book.mall.leetcode.array;

/**
 * ClassName: SearchInsertPosition
 * Description:
 * 35. 搜索插入位置
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * date: 2020/8/2 2:37 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,6};
//        int target = 5;
//        int target = 2;
//        int target = 7;
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * 1.二分法查找
     *
     * @param nums
     * @param target
     * @return
     */
    private static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return -1;
//
//        int left = 0;
//        int right = nums.length - 1;
//        int mid = (left + right) / 2;
//        while (left <= right) {
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            } else {
//                return mid;
//            }
//            mid = (left + right) / 2;
//        }
//        return left;
    }
}
