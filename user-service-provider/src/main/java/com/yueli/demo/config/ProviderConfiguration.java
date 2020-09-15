package com.yueli.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@Configuration
@EnableDubbo(scanBasePackages = "com.yueli.demo.service.impl")
@PropertySource("classpath:dubbo.properties")
public class ProviderConfiguration {
       
}
