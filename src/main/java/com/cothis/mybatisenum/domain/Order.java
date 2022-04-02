package com.cothis.mybatisenum.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
	private final String odNo;
	private final String customerName;
	private OrderStatus orderStatus;
}
