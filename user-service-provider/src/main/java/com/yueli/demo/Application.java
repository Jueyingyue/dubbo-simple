package com.yueli.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
    	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
    	 context.start();
    	 System.out.println("dubbo service started");
         System.in.read(); 
    }
}
