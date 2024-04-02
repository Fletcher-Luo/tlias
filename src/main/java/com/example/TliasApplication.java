package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Import({MyImportSelector.class})
//@ServletComponentScan
@SpringBootApplication
public class TliasApplication {
	public static void main(String[] args) {
		SpringApplication.run(TliasApplication.class, args);
	}
}
