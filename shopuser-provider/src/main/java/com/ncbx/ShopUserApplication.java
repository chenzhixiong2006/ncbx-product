package com.ncbx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用户服务提供者
 * @author win7
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ShopUserApplication {
	public static void main(String[] args) {
        SpringApplication.run( ShopUserApplication.class, args );
    }
}
