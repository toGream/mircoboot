package com.huawei.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.huawei.user.service.IUserService;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private IUserService iuserService;
	
	@GetMapping("/sayHello")
	public String sayHello(@RequestParam(value="userName") String userName) {
		System.err.println("iuserService: [userName=" + userName+"]");
		return iuserService.sayHello(userName);
	}
}
