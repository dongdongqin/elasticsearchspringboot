package com.XXXX.monitor;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * exclude=ElasticsearchDataAutoConfiguration.class can solve the exception below
 * elastic NoClassDefFoundError: org/springframework/data/mapping/model/Property
 */

@SpringBootApplication
public class Application  {

	public static void main(String args[]) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}