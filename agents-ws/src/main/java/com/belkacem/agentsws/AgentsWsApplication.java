package com.belkacem.agentsws;

import com.belkacem.agentsservice.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.belkacem")
@Import(ServiceConfig.class)
public class AgentsWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentsWsApplication.class, args);
	}

}
