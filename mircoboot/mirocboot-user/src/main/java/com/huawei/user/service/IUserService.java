package com.huawei.user.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="spring-cloud-base")
public interface IUserService {
	
	@GetMapping(value="/hello/{name}")
	public String sayHello(@PathVariable(value="name") String name);
}
