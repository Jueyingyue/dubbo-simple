package com.yueli.consumer;

import java.io.IOException;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yueli.service.GreetingsService;

@EnableDubboConfig
public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");
	
    @SuppressWarnings("resource")
    public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
         context.start();
          GreetingsService service =context.getBean("greetingsService", GreetingsService.class);;
          String message = service.sayHi("dubbo");
          System.out.println(message);
         try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 按任意键退出
    }
}
