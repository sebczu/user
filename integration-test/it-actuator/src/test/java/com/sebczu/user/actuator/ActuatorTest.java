package com.sebczu.user.actuator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

import com.sebczu.user.it.main.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@IntegrationTest
public class ActuatorTest {

  private static final String HEALTH_URL = "/actuator/health";

  @Autowired
  private TestRestTemplate restClient;

  @Test
  void shouldBeHealthy() {
    //when
    ResponseEntity<String> responseEntity = restClient.getForEntity(HEALTH_URL, String.class);

    //then
    assertEquals(OK, responseEntity.getStatusCode());
  }

}
