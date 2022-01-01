package com.sebczu.template.user.controller;

import com.sebczu.template.user.api.ExternalUserAPI;
import com.sebczu.template.user.domain.User;
import com.sebczu.template.user.service.CreateUserService;
import com.sebczu.template.user.service.GetUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExternalUserController implements ExternalUserAPI {

  private final CreateUserService createService;
  private final GetUserService getService;

  @Override
  public User create(User user) {
    log.info("endpoint invoked: create");
    return createService.create(user);
  }

  @Override
  public User get(long id) {
    log.info("endpoint invoked: get");
    return getService.get(id);
  }

}
