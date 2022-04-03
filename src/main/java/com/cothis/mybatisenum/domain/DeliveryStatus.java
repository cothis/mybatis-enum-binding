package com.cothis.mybatisenum.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DeliveryStatus {
    APPLY("10"), SHIPPING("20"), SHIPPED("30");

    private final String code;
}
