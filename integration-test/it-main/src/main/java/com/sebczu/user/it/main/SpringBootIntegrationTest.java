package com.sebczu.user.it.main;

import static java.util.TimeZone.getTimeZone;

import java.util.TimeZone;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sebczu")
public class SpringBootIntegrationTest {

  static {
    TimeZone.setDefault(getTimeZone("UTC"));
  }

}
