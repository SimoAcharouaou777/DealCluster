package com.progresssoft.dealcluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(TestcontainersConfiguration.class)
public class TestDealclusterApplication {

	public static void main(String[] args) {
		SpringApplication.from(DealclusterApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
