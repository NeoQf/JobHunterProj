package com.nowcoder.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan
// 	扫描配置类同级和下级包下的Bean(com.nowcoder.example)
//	@Component, @Repository, @Service, @Controller
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		// 1.加载配置文件
		// 2.启动Tomcat
		// 3.创建Spring容器
		// 4.自动扫描Bean并将其装配到容器里
		SpringApplication.run(ExampleApplication.class, args);
	}

}
