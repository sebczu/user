package com.sebczu.user.user.service;

import com.sebczu.user.user.converter.UserConverter;
import com.sebczu.user.user.domain.User;
import com.sebczu.user.user.repository.UserRepository;
import com.sebczu.user.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

  private final UserConverter converter;
  private final UserRepository repository;

  public User create(User user) {
    UserEntity entity = converter.convert(user);
    UserEntity savedEntity = repository.save(entity);
    return converter.convert(savedEntity);
  }
}
