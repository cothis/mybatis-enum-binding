package com.cothis.mybatisenum.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {
	private final String odNo;
	private final String customerName;
	private OrderStatus orderStatus;
	private DeliveryStatus deliveryStatus;
}
