package com.cothis.mybatisenum.config;

import com.cothis.mybatisenum.domain.OrderStatus;
import com.cothis.mybatisenum.typehandlers.EnumCodeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean
    public EnumCodeHandler<OrderStatus> orderStatusEnumHandler() {
        return new EnumCodeHandler<>(OrderStatus.class);
    }
}
