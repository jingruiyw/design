package com.book.mall.code.binary;

/**
 * ClassName: BinarySearch
 * Description:
 * date: 2022/5/20 6:05 下午
 * 704. 二分查找
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 12));
    }


    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int p1 = 0;
        int p2 = nums.length - 1;
        int mid = (p1 + p2) / 2;
        while (p1 <= p2) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                p2 = mid - 1;
            } else {
                p1 = mid + 1;
            }
            mid = (p1 + p2) / 2;
        }
        return -1;
    }
}
