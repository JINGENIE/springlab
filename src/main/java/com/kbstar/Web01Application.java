package com.kbstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class Web01Application {

	public static void main(String[] args) {
		SpringApplication.run(Web01Application.class, args);
	}

	//JSP Setting
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/views/");
//		("/WEB-INF/views/"); 여기에 jsp를 만들자(우리가 세팅하기 나름)
		resolver.setSuffix(".jsp");
		return resolver;
	}


}
