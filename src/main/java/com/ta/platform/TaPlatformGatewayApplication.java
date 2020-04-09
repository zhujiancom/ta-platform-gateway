package com.ta.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TaPlatformGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaPlatformGatewayApplication.class, args);
    }

}
