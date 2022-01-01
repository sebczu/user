package com.sebczu.template.user.domain.exception;

import static java.lang.String.format;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(long id) {
    super(format("User with id %d not found", id));
  }

}
