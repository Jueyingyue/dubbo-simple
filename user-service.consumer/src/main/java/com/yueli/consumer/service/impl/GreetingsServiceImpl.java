package com.yueli.consumer.service.impl;

import org.apache.dubbo.common.utils.StringUtils;

import com.yueli.service.GreetingsService;

public class GreetingsServiceImpl implements GreetingsService{
	private final GreetingsService greetingsService;  
	
	public GreetingsServiceImpl(GreetingsService greetingsService) {
		super();
		this.greetingsService=greetingsService;
	}

	@Override
	public String sayHi(String name) throws Exception {
		System.out.println("GreetingsServiceImpl本地存根代码被调用.......");
		// TODO Auto-generated method stub
		if(!StringUtils.isBlank(name)) {
			return greetingsService.sayHi(name);
		}
		return null;
	}

}
