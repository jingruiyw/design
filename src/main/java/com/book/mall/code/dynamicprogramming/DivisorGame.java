package com.book.mall.code.dynamicprogramming;

/**
 * ClassName: DivisorGame
 * Description:
 * 1025. 除数博弈
 * <p>
 * date: 2021/2/13 6:04 下午
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字N。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一x，满足0 < x < N 且N % x == 0。
 * 用 N - x替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 *
 * 示例 2：
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(divisorGame(1));
        System.out.println(divisorGame(2));
    }

    /**
     * 枚举规律可知，奇偶结果相反
     *
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
























































