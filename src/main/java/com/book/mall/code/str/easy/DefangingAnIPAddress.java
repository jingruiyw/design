package com.book.mall.code.str.easy;

/**
 * ClassName: DefangingAnIPAddress
 * Description:
 * 1108. IP 地址无效化
 *
 * date: 2020/7/9 1:16 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class DefangingAnIPAddress {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
