package com.sebczu.user.user.domain;

import javax.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

  @Null
  private Long id;
  private String username;
  private String password;

}