package com.mircoboot.base.service;

import org.springframework.stereotype.Service;

@Service
public class BaseService implements IBaseService {

	@Override
	public String hello(String name) {
		System.err.println("BaseService:[name=" + name + "]");
		return "hello, " + name;
	}

}
