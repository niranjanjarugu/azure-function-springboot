package com.sample;

import java.io.UnsupportedEncodingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class AzureFunctionSpringApplication {
	
	public static void main(String[] args) throws UnsupportedEncodingException {

		SpringApplication.run(AzureFunctionSpringApplication.class, args);
	}		 

}
