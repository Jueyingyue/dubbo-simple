package com.yueli.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yueli.service.GreetingsService;
import com.yueli.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private GreetingsService greetingsService;
	
    @Override
    public String attributes() {
    	String saySomeThings=greetingsService.sayHi("dubbo");
        return "属性： " + saySomeThings;
    }
}
