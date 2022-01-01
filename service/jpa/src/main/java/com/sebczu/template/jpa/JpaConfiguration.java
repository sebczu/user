package com.sebczu.template.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.sebczu.template")
@EntityScan(basePackages = "com.sebczu.template")
public class JpaConfiguration {

}