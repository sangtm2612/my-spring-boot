package com.example.springbootsample.services;

import com.example.springbootsample.entities.User;
import com.example.springbootsample.requests.UserRequestDto;

import java.lang.reflect.InvocationTargetException;

public interface UserService {

    User getUserByUsername(String username);

    void createUser(UserRequestDto req) throws InvocationTargetException, IllegalAccessException;

}
