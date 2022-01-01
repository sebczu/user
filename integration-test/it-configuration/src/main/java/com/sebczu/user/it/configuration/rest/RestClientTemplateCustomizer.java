package com.sebczu.user.it.configuration.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Slf4j
@Component
public class RestClientTemplateCustomizer implements RestTemplateCustomizer {

  @Autowired
  private RestClientLoggingInterceptor loggingInterceptor;

  @Value("${integration.test.service.hostname}")
  private String hostname;
  @Value("${integration.test.service.port}")
  private String port;

  @Override
  public void customize(RestTemplate restTemplate) {
    String uri = "http://" + hostname + ":" + port;
    log.info("service uri: " + uri);
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(uri));
    restTemplate.getInterceptors().add(loggingInterceptor);
    restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
  }

}
