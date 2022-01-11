package com.atguigu.demowebflux01.controller;

import com.atguigu.demowebflux01.entity.User;
import com.atguigu.demowebflux01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    //    根据用id，查询用户
    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    //查询所有的用户
    @GetMapping("/user")
    public Flux<User> getAllUser() {
        return userService.getAllUser();
    }

    //插入用户
    @PostMapping("/saveuser")
    public Mono<Void> saveUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);


    }


}
