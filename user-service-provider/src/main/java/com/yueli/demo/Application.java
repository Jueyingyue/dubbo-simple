package com.yueli.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
    	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
    	 System.out.println("dubbo service started");
    	 context.start();
         System.in.read(); 
    }
}
