package com.cothis.mybatisenum.repository;

import com.cothis.mybatisenum.config.HikariConfig;
import com.cothis.mybatisenum.config.MyBatisConfig;
import com.cothis.mybatisenum.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import static com.cothis.mybatisenum.domain.DeliveryStatus.*;
import static com.cothis.mybatisenum.domain.OrderStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@Import({HikariConfig.class, MyBatisConfig.class})
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class OrderMapperTest {

	@Autowired
	OrderMapper orderMapper;

	@Test
	void createOrder() {
		Order order = new Order("test1", "tester", ORDER, SHIPPED);
		orderMapper.createOrder(order);

		assertThat(orderMapper.findByOdNo(order.getOdNo())).isEqualTo(order);
	}

	@Test
	void findByOdNo() {
		orderMapper.createOrder(new Order("test1", "tester", ORDER, SHIPPED));
		orderMapper.createOrder(new Order("test2", "tester", ORDER_CANCEL, SHIPPING));
		orderMapper.createOrder(new Order("test3", "tester", ORDER_CHANGE, APPLY));

		Order test1 = orderMapper.findByOdNo("test1");
		Order test2 = orderMapper.findByOdNo("test2");
		Order test3 = orderMapper.findByOdNo("test3");

		log.info("test1: {}", test1);
		log.info("test2: {}", test2);
		log.info("test3: {}", test3);

		assertThat(test1.getOrderStatus()).isEqualTo(ORDER);
		assertThat(test2.getOrderStatus()).isEqualTo(ORDER_CANCEL);
		assertThat(test3.getOrderStatus()).isEqualTo(ORDER_CHANGE);
	}
}