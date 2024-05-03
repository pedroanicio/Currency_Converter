package br.com.service.gameservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("game-service")
public class FooBarController {
	
	private Logger logger = LoggerFactory.getLogger(FooBarController.class);
	
	//testing resilience4j
	@GetMapping("/foo-bar")
	@Retry(name = "default") // 3 requests
	public String fooBar() {
		logger.info("Request received");
		var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class); // cause an error
		//return "Foo-Bar!";
		
		return response.getBody();
	}
	
	// it will make 3 requests, and if it doesnt works, cause an error.

}
