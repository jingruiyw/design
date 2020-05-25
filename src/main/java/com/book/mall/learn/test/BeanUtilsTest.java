package com.book.mall.learn.test;

import com.alibaba.fastjson.JSON;
import com.book.mall.learn.model.User;
import com.book.mall.learn.model.UserInfo;
import org.springframework.beans.BeanUtils;

/**
 * ClassName: BeanUtilsTest
 * Description: BeanUtils.copyProperties 源数据为null字段会覆盖新数据已有字段值,没有的字段值不受影响
 * date: 2020/3/25 11:18 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class BeanUtilsTest {

	public static void main(String[] args) {
		User user = new User();
		user.setName("jr");
		user.setAge("12");
		user.setSchool("SanZ");
//		user.setRemark(null);


		UserInfo userInfo = new UserInfo();
		userInfo.setName("jr");
		userInfo.setAge("12");
		userInfo.setSchool("SanZ");
		userInfo.setRemark("mmmmmm");
		userInfo.setFlag(true);

		BeanUtils.copyProperties(user, userInfo);
		System.out.println(JSON.toJSONString(userInfo));
	}
}
