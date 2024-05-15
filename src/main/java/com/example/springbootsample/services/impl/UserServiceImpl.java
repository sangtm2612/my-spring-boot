package com.example.springbootsample.services.impl;

import com.example.springbootsample.entities.User;
import com.example.springbootsample.repositories.UserRepository;
import com.example.springbootsample.requests.UserRequestDto;
import com.example.springbootsample.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @SneakyThrows
    @Override
    public void createUser(UserRequestDto req) {
        User user = new User();
        BeanUtils.copyProperties(user, req);
        userRepository.save(user);
    }


}
