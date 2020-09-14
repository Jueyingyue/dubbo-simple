package com.yueli.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.yueli.consumer.service.impl.PersonServiceImpl;
import com.yueli.service.GreetingsService;

@EnableDubboConfig
public class Application {	
	
	private static Logger log=Logger.getLogger(Application.class);
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
    	/*ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(GreetingsService.class);
        GreetingsService service = reference.get();
        String message = service.sayHi("dubbo");
        System.out.println(message);*/
    	
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
