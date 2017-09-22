package com.chy.yihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
