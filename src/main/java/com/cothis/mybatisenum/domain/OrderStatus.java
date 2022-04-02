package com.cothis.mybatisenum.domain;

import com.cothis.mybatisenum.typehandlers.EnumCode;
import lombok.Getter;

@Getter
public enum OrderStatus implements EnumCode {
	ORDER(10), ORDER_CANCEL(20), ORDER_CHANGE(30), ORDER_REFUND(40);

	private final int code;

	OrderStatus(int code) {
		this.code = code;
	}
}
