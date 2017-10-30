package com.jwh.demo.springBootConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource({
		/*"classpath:/spring/dubbo-consumer.xml"*/
		"classpath:/spring/applicationContext.xml"
})
public class StartApplicationConsumer {
	
	private static Logger logger = LoggerFactory.getLogger(StartApplicationConsumer.class);
	

	public static void main(String[] args) {
		SpringApplication.run(StartApplicationConsumer.class, args);
		logger.info("Spring Boot 启动成功******");
	}
}
