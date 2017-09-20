package com.chy.yihe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiError")
	public String hiService(String name) {
		String str = restTemplate.getForObject("http://EUREKACLIENT/hi?name=" + name, String.class);
		return str;
	}

	public String hiError(String name) {
		return "hi," + name + ",sorry,error!";
	}

}
