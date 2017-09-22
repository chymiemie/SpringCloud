package com.chy.yihe.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chy.yihe.ServiceHiApplication;

@RestController
public class ServiceHiController {

	private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/hi")
	public String callHome() {
		LOG.log(Level.INFO, "calling trace service-hi");
		return restTemplate.getForObject("http://localhost:8989/hi", String.class);
	}

	@RequestMapping(value = "/hello")
	public String info() {
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

}
