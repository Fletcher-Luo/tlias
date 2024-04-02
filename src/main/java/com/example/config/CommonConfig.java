package com.example.config;

import com.example.pojo.Dept;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CommonConfig {
    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public Dept dept() { return new Dept(); }
}
