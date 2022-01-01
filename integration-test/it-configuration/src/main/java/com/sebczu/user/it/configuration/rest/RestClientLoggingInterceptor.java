package com.sebczu.user.it.configuration.rest;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RestClientLoggingInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    traceRequest(request, body);
    ClientHttpResponse response = execution.execute(request, body);
    traceResponse(response);
    return response;
  }

  private void traceRequest(HttpRequest request, byte[] body) {
    log.info("===========================request begin================================================");
    log.info("URI         : {}", request.getURI());
    log.info("Method      : {}", request.getMethod());
    log.info("Headers     : {}", request.getHeaders());
    log.info("Request body: {}", new String(body, UTF_8));
    log.info("==========================request end================================================");
  }

  private void traceResponse(ClientHttpResponse response) throws IOException {
    log.info("============================response begin==========================================");
    log.info("Status code  : {}", response.getStatusCode());
    log.info("Headers      : {}", response.getHeaders());
    log.info("Response body: {}", getResponseBody(response));
    log.info("=======================response end=================================================");
  }

  private String getResponseBody(ClientHttpResponse response) throws IOException {
    return new BufferedReader(new InputStreamReader(response.getBody(), UTF_8))
        .lines()
        .collect(Collectors.joining(System.lineSeparator()));
  }
}