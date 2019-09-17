package mainclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "service", "controller","restcontroller","mainclass" })
@EntityScan(basePackages = { "bean" })
@EnableJpaRepositories(basePackages = { "repository" })
public class EmployeeFileAccessManagementSystem {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeFileAccessManagementSystem.class, args);

	}

}
