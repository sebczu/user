package com.sebczu.user.it.configuration.rest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientTemplateConfiguration {

  @Bean
  public TestRestTemplate restClient(RestClientTemplateCustomizer customizer) {
    RestTemplateBuilder builder = new RestTemplateBuilder(customizer);
    return new TestRestTemplate(builder);
  }

}
