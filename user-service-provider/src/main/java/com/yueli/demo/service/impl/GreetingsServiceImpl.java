package com.yueli.demo.service.impl;

import com.yueli.service.GreetingsService;

public class GreetingsServiceImpl implements GreetingsService {
	
    @Override
    public String sayHi(String name) throws Exception{
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "hi, " + name;
    }
}
