package com.sebczu.user.user.api;

import com.sebczu.user.user.domain.User;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/external/user")
public interface ExternalUserAPI {

  @PostMapping
  User create(@Valid @RequestBody @NotNull User user);

  @GetMapping("/{id}")
  User get(@PathVariable long id);

}
