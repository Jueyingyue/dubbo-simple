package com.yueli.consumer.service.impl;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.yueli.service.GreetingsService;
import com.yueli.service.PersonService;
@SuppressWarnings("deprecation")
@Service("personService")
public class PersonServiceImpl implements PersonService {
	//@Reference(url="127.0.0.1:20883") //dubbo直连跳过注册中心
	@Reference
	private GreetingsService greetingsService;

	@Override
    public String attributes(){
		String saySomeThings="";
		 try {
    	    saySomeThings=greetingsService.sayHi("dubbo");
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("超时"+e.getMessage());
				e.printStackTrace();
			} 
        return saySomeThings;
    }
}
