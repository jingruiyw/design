package com.book.mall.code.stack;

import java.util.PriorityQueue;

/**
 * ClassName: KthLargestElementInAStream
 * Description:
 * 703. 数据流中的第 K 大元素
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * date: 2021/4/18 11:13 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class KthLargestElementInAStream {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        //构造优先队列
        for (Integer num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            //使用小顶堆
            pq.poll();
        }
        return pq.peek();
    }
}
