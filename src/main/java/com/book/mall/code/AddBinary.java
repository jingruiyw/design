package com.book.mall.code;

/**
 * ClassName: AddBinary
 * Description:
 * 67. 二进制求和
 * <p>
 * date: 2020/8/5 11:05 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1", "11"));
    }

    /**
     * 倒位相加减，ca变量控制是否进位
     * 最后再翻转结果
     *
     * @param a
     * @param b
     * @return
     */
    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //表示进位
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            ca = sum / 2;
        }

        if (ca == 1) {
            sb.append(ca);
        }
        return sb.reverse().toString();
    }
}
