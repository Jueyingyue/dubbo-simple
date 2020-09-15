package com.yueli.demo;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.Protocol;
import com.yueli.demo.config.ProviderConfiguration;
import com.yueli.demo.service.impl.GreetingsServiceImpl;
import com.yueli.service.GreetingsService;

public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");
    
    public static void method1() throws Exception {
    	Integer port=20880;
    	for(int i=0;i<4;i++) {
    		ServiceConfig<GreetingsService> service = new ServiceConfig<>();
        	ProtocolConfig protocol=new ProtocolConfig();
            protocol.setPort(port+i);
            protocol.setName("dubbo");
            service.setProtocol(protocol);

            service.setApplication(new ApplicationConfig("first-dubbo-provider"+i));
            service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
            service.setInterface(GreetingsService.class);
            service.setRef(new GreetingsServiceImpl());
            service.export();
            System.out.println("dubbo service started");
    	}
    	
        new CountDownLatch(1).await();
    }
    
    public static void method2() throws Exception {
    	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
    	 context.start();
         System.out.println("dubbo service started");
         new CountDownLatch(1).await();
    }
    
    public static void method3() throws Exception {
    	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        System.out.println("dubbo service started");
        context.start();
        new CountDownLatch(1).await();
    }

    public static void main(String[] args) throws Exception {
    	method3();
    }
}
