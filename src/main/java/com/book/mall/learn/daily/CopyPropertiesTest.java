package com.book.mall.learn.daily;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CopyPropertiseTest
 * Description:
 * date: 2020/11/24 11:16 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class CopyPropertiesTest {

    public static void main(String[] args) {

        PropertiesBean source = new PropertiesBean();
        source.setParam1("param1");
        source.setParam2(2);
        source.setParam3(3.33);
        source.setParam4(4.4f);
        source.setParam5("param1");
        List<PropertiesBean> list = new ArrayList<>(10000000);
        long startTime = System.currentTimeMillis();
        System.out.println("手动赋值----> 开始循环时间：" + startTime);
        for (int i = 0; i < 20000000; i++) {
            PropertiesBean propertiesBean = new PropertiesBean();
            //1.手动写入
//            propertiesBean.setParam1("param1");
//            propertiesBean.setParam2(2);
//            propertiesBean.setParam3(3.33);
//            propertiesBean.setParam4(4.4f);
//            propertiesBean.setParam5("param1");
            //2.BeanUtils.copyProperties Spring的beanUtils
            BeanUtils.copyProperties(source, propertiesBean);
            list.add(propertiesBean);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("----> 结束循环时间：" + endTime);
        System.out.println("----> 耗时时间差：" + (endTime - startTime));
    }
}
