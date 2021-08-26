package com.zgsolucoes.mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShortenUrlsApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ShortenUrlsApiApplication.class, args);
	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(ShortenUrlsApiApplication.class); }
	 */
}
