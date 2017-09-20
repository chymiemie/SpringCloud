package com.chy.yihe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaClientApp.class, args);
    }
    
    @Value("${server.port}")
    private String port;
    
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String home(@RequestParam String name){
    	return "hi " + name + "i am from port:" + port;
    }
}
