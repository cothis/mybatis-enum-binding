package com.cothis.mybatisenum.domain;

import com.cothis.mybatisenum.typehandlers.EnumCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DeliveryStatus implements EnumCode {
    APPLY("10"), SHIPPING("20"), SHIPPED("30");

    private final String code;
}
