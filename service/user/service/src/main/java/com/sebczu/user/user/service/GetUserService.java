package com.sebczu.user.user.service;

import com.sebczu.user.user.converter.UserConverter;
import com.sebczu.user.user.domain.User;
import com.sebczu.user.user.domain.exception.UserNotFoundException;
import com.sebczu.user.user.repository.UserRepository;
import com.sebczu.user.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserService {

  private final UserConverter converter;
  private final UserRepository repository;

  public User get(long id) {
    UserEntity entity = repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    return converter.convert(entity);
  }
}
