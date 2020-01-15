package rs.uns.ftn.acs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppointmentSchedulingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentSchedulingServiceApplication.class, args);
	}

}
