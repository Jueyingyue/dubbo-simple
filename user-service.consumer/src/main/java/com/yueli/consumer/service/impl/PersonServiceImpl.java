package com.yueli.consumer.service.impl;

import com.yueli.service.GreetingsService;
import com.yueli.service.PersonService;

public class PersonServiceImpl implements PersonService {
	
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
