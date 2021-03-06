package com.wisely.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SomeHystrixService {

	@Autowired(required=false)
	RestTemplate restTemplate; // 1

	@HystrixCommand(fallbackMethod = "fallbackSome") // 断路器支持
	public String getSome() {
		return restTemplate.getForObject("http://some/getsome", String.class);
	}

	public String fallbackSome() {
		return "some service模块故障";
	}
}