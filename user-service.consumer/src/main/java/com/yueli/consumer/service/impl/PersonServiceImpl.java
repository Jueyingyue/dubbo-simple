package com.yueli.consumer.service.impl;


import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yueli.service.GreetingsService;
import com.yueli.service.PersonService;
@SuppressWarnings("deprecation")
@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Reference
	private GreetingsService greetingsService;
	
	
    public void setGreetingsService(GreetingsService greetingsService) {
		this.greetingsService = greetingsService;
	}

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
