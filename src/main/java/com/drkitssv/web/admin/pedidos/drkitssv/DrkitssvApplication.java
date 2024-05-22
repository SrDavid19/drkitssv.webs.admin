package com.drkitssv.web.admin.pedidos.drkitssv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.drkitssv.web.admin.pedidos.drkitssv.repository")
public class DrkitssvApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrkitssvApplication.class, args);
	}

}
