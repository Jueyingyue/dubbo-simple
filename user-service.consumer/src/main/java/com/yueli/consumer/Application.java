package com.yueli.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yueli.consumer.service.impl.PersonServiceImpl;

@EnableDubboConfig
public class Application {	
	
	private static Logger log=Logger.getLogger(Application.class);

    @SuppressWarnings("resource")
    public static void main(String[] args) {
		  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
          context.start();
        try {
          PersonServiceImpl service =context.getBean("personServiceImpl", PersonServiceImpl.class);;
          String message = service.attributes();
          System.out.println(message);
		  System.in.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("超时"+e.getMessage());
			e.printStackTrace();
		} // 按任意键退出
    }
}
