package com.cothis.mybatisenum.repository;

import com.cothis.mybatisenum.config.HikariConfig;
import com.cothis.mybatisenum.domain.Order;
import com.cothis.mybatisenum.domain.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({HikariConfig.class})
@Slf4j
class OrderMapperTest {

	@Autowired
	OrderMapper orderMapper;

	@Test
	void createOrder() {
		orderMapper.createOrder(new Order("test1", "tester", OrderStatus.ORDER));
	}

	@Test
	void findByOdNo() {
		orderMapper.createOrder(new Order("test1", "tester", OrderStatus.ORDER));
		orderMapper.createOrder(new Order("test2", "tester", OrderStatus.ORDER_CANCEL));
		orderMapper.createOrder(new Order("test3", "tester", OrderStatus.ORDER_CHANGE));

		Order test1 = orderMapper.findByOdNo("test1");
		Order test2 = orderMapper.findByOdNo("test2");
		Order test3 = orderMapper.findByOdNo("test3");

		log.info("test1: {}", test1);
		log.info("test2: {}", test2);
		log.info("test3: {}", test3);

		Assertions.assertThat(test1.getOrderStatus()).isEqualTo(OrderStatus.ORDER);
		Assertions.assertThat(test2.getOrderStatus()).isEqualTo(OrderStatus.ORDER_CANCEL);
		Assertions.assertThat(test3.getOrderStatus()).isEqualTo(OrderStatus.ORDER_CHANGE);
	}
}