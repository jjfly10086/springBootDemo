package com.jwh.demo.springBoot;

import com.alibaba.rocketmq.client.exception.MQClientException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
@ImportResource({
		/*"classpath:/spring/dubbo-provider.xml"*/
		"classpath:/spring/applicationContext.xml"
})
@MapperScan("com.jwh.demo.springBoot.dao")//dao接口所在包
public class StartApplicationProvider {
	
	private static Logger logger = LoggerFactory.getLogger(StartApplicationProvider.class);
	
	/**
	 * 注入datasource数据源
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource(){
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}
	/**
	 * 设置sqlSessionFactory
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
		return sqlSessionFactoryBean;
	}
	/**
	 * 配置事务管理
	 */
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	public static void main(String[] args) throws MQClientException{
		SpringApplication.run(StartApplicationProvider.class, args);
		//MQConsumer consumer = new MQConsumer("PushConsumer");
		//consumer.start();
		logger.info("Spring Boot 启动成功******");
	}
}
