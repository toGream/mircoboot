package com.huawei.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
	@Autowired
	public RestTemplate restTemplate;
	
	public String hiService(String name) {
		return restTemplate.getForObject("http://spring-cloud-base/user/hello/"+name, String.class);
	}
}
