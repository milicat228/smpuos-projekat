package rs.uns.ftn.acs;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.PageJacksonModule;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;
import com.netflix.hystrix.Hystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

	@Bean
	public Module pageJacksonModule() {
		return new PageJacksonModule();
	}

	@PreDestroy
	public void cleanUp() {
		Hystrix.reset();
	}
}
