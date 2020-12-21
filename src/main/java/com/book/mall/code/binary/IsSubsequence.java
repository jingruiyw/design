package com.book.mall.code.binary;

/**
 * ClassName: IsSubsequence
 * Description:
 * 392. 判断子序列
 * date: 2020/12/21 11:59 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class IsSubsequence {

    /**
     * 双指针
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length() && t1 < t.length()) {
            if (s.charAt(s1) == t.charAt(t1)) {
                s1++;
            }
            t1++;
        }
        return s1 == s.length();
    }
}
