package com.yueli.consumer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@Configuration
@EnableDubbo(scanBasePackages = "com.yueli.consumer.service.impl")
@PropertySource("classpath:dubbo.properties")
@ComponentScan(value = {"com.yueli.consumer.service.impl"})
public class ConsumerConfiguration {

}
