 package com.batch.example.boot_batch_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootBatchExampleApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(BootBatchExampleApplication.class, args)));
	}

}
