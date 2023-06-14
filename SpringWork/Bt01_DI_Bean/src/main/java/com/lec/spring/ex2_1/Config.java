package com.lec.spring.ex2_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    //	@Bean
    public OperatorBean minus() {
        return new MinusOp(15, 8);
    }

    @Bean
    public OperatorBean plus() {
        return new PlusOp(4, 30);
    }
}
