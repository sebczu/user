package com.sebczu.user.user.converter;

import com.sebczu.user.user.domain.User;
import com.sebczu.user.user.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

  public UserEntity convert(User user) {
    UserEntity entity = new UserEntity();
    entity.setUsername(user.getUsername());
    entity.setPassword(user.getPassword());
    return entity;
  }

  public User convert(UserEntity entity) {
    User user = new User();
    user.setId(entity.getId());
    user.setUsername(entity.getUsername());
    user.setPassword(entity.getPassword());
    return user;
  }

}
