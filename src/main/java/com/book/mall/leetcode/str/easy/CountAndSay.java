package com.book.mall.leetcode.str.easy;

/**
 * ClassName: CountAndSay
 * Description:
 * 38. 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * date: 2020/7/15 1:48 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }

    /**
     * 1.递归：注意
     *
     * @param n
     * @return
     */
    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        int pre = 0;
        int curr = 1;
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        for (curr = 1; curr < str.length(); curr++) {
            if (str.charAt(curr) != str.charAt(pre)) {
                int count = curr - pre;
                sb.append(count).append(str.charAt(pre));
                pre = curr;
            }
        }

        //防止最后一段数相同。pre!=curr说明后一段 pre 到 curr-1是相同的
        if (pre != curr) {
            int count = curr - pre;
            sb.append(count).append(str.charAt(pre));
        }
        return sb.toString();
    }

    /**
     * 2.递归，自己改的 curr++；
     *
     * @param n
     * @return
     */
    public String countAndSayV2(int n) {
        if (n == 1) {
            return "1";
        }
        int pre = 0;
        int curr = 1;
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(pre)) {
                int count = curr - pre;
                sb.append(count).append(str.charAt(pre));
                pre = curr;
            }
            curr++;
        }

        //防止最后一段数相同。pre!=curr说明后一段 pre 到 curr-1是相同的
        if (pre != curr) {
            int count = curr - pre;
            sb.append(count).append(str.charAt(pre));
        }
        return sb.toString();
    }
}
