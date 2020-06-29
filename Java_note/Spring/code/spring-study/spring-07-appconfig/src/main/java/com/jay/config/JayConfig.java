package com.jay.config;

import com.jay.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jay.pojo")
public class JayConfig {

    // register a bean
    @Bean(value = {"user", "getUser"})
    public User getUser() {
        return new User();
    }
}
