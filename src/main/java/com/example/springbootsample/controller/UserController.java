package com.example.springbootsample.controller;

import com.example.springbootsample.common.BaseResponse;
import com.example.springbootsample.entities.User;
import com.example.springbootsample.requests.UserRequestDto;
import com.example.springbootsample.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getUserByUsername(@RequestParam(required = false, value = "username") String username) {
        return ResponseEntity.ok(new BaseResponse<>(userService.getUserByUsername(username)));
    }

    @SneakyThrows
    @PostMapping("create-user")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto req) {
        userService.createUser(req);
        return ResponseEntity.ok("");
    }

}
