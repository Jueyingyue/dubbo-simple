package com.yueli.demo.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.yueli.service.GreetingsService;
@Service
public class GreetingsServiceImpl implements GreetingsService {
	
    @Override
    public String sayHi(String name) throws Exception{
    	name="hi, " + name;
        System.out.println(name);
    	return "hi, " + name;
    }
}
