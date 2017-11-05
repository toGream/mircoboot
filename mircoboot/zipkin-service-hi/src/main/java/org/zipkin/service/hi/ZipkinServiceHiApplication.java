package org.zipkin.service.hi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;

@SpringBootApplication
@RestController
public class ZipkinServiceHiApplication {
	private static final Logger log = Logger.getLogger(ZipkinServiceHiApplication.class.getName());
	
	@Autowired
	private RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServiceHiApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping("/hi")
	public String callHome() {
		log.info("calling trace zipkin-service-hi");
		return restTemplate.getForObject("http://localhost:8989/hi", String.class);
	}
	
	@RequestMapping("/info")
	public String info() {
		log.info("calling trace zipkin-service-hi");
		return "i'm zipkin-service-hi";
	}
	
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
