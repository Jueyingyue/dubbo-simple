package com.yueli.consumer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.yueli.consumer.config.ConsumerConfiguration;
import com.yueli.consumer.service.impl.PersonServiceImpl;
import com.yueli.service.GreetingsService;

public class Application{	
	
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");
    static int threadCount = 21;
    private final static CountDownLatch mCountDownLatch = new CountDownLatch(1);
    
    public static void method1(int i) throws Exception {
    	ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(GreetingsService.class);
        GreetingsService service = reference.get();
        String message = service.sayHi("dubbo"+i);
        System.out.println(message);
    }
    
    public static void method2(int i) throws Exception {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();
        GreetingsService service =context.getBean("greetingsService", GreetingsService.class);;
        String message = service.sayHi("dubbo"+i);
        System.out.println(message);
    }
    
    public static void method3(int i) throws InterruptedException {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final PersonServiceImpl annotationAction = (PersonServiceImpl) context.getBean("personService");
        String hello = annotationAction.attributes();
        System.out.println(hello);
    }
    
    public static void method4(int i) throws InterruptedException {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();
        final PersonServiceImpl annotationAction = (PersonServiceImpl) context.getBean("personServiceImpl");
        String hello = annotationAction.attributes();
        System.out.println(hello);
    }
    


    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
    	ExecutorService service = Executors.newCachedThreadPool();
    	for (int i = 0; i < threadCount; i++) {
        	final int j=i;
    	    new Thread() {
    	    	 @Override
    	    	    public void run() {
    	    	        try {  
    	    	        	mCountDownLatch.await();
    	    	        	try {
    	    	        		method4(j);
    	    				} catch (Exception e) {
    	    					// TODO Auto-generated catch block
    	    					e.printStackTrace();
    	    				}
    	    	        } catch (InterruptedException e) {  
    	    	                e.printStackTrace();  
    	    	        }
    	    	    }

    	    }.start();
    	}
        mCountDownLatch.countDown();
        new CountDownLatch(1).await();
    }
}
