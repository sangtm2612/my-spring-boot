package com.example.springbootsample.controller;

import com.example.springbootsample.requests.UserRequestDto;
import com.example.springbootsample.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getUserByUsername(@RequestParam(required = false, value = "username") String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @SneakyThrows
    @PostMapping("create-user")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto req) {
        userService.createUser(req);
        return ResponseEntity.ok("");
    }

}
