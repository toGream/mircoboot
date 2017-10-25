package com.mircoboot.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mircoboot.base.service.IBaseService;

@RestController
public class BaseController {
	@Autowired
	private IBaseService baseService;
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable(value="userName") String name) {
		return baseService.hello(name);
	}
}
