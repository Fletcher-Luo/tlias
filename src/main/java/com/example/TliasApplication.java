package com.example;

import com.example.config.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

//@Import({MyImportSelector.class})
//@ServletComponentScan
@SpringBootApplication
public class TliasApplication {
	public static void main(String[] args) {
		SpringApplication.run(TliasApplication.class, args);
	}
}
