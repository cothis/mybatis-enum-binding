package com.cothis.mybatisenum.repository;

import com.cothis.mybatisenum.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

	@Insert("INSERT INTO orders(od_no, customer_name, order_status, delivery_status) VALUES(#{odNo}, #{customerName}, #{orderStatus}, #{deliveryStatus})")
	void createOrder(Order order);

	@Select("SELECT od_no, customer_name, order_status, delivery_status FROM orders WHERE od_no = #{odNo}")
	Order findByOdNo(String odNo);
}
