package com.sebczu.template.user.service;

import com.sebczu.template.user.converter.UserConverter;
import com.sebczu.template.user.domain.User;
import com.sebczu.template.user.domain.exception.UserNotFoundException;
import com.sebczu.template.user.repository.UserRepository;
import com.sebczu.template.user.repository.entity.UserEntity;
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
