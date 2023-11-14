package com.music.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PracticeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		// Refer to these tutorials for SpringAPI hosting:
		// - https://tanzu.vmware.com/developer/guides/serverless-spring/
		// - https://www.youtube.com/watch?v=GGPPkUcHleQ
		//   ^^ I currently use this approach, with AWS API Gateway and AWS Lambda
		SpringApplication.run(PracticeApplication.class, args);
	}

}
