package com.book.mall.mall;

import com.supply.mapper.GoodsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplyApplicationTests {

	@Autowired
	DataSource dataSource;
	@Autowired
	GoodsMapper goodsMapper;

	@Test
	public void contextLoads() {
		System.out.println(dataSource.getClass());

		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getById() {
		System.out.println(goodsMapper.getById(1L).getName());
	}

}
