package com.progresssoft.dealcluster;

import org.springframework.boot.SpringApplication;

public class TestDealclusterApplication {

	public static void main(String[] args) {
		SpringApplication.from(DealclusterApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
