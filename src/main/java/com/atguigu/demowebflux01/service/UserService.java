package com.atguigu.demowebflux01.service;

import com.atguigu.demowebflux01.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//用户操作接口
public interface UserService {

    //根据用id，查询用户

    Mono<User> getUserById(int id);

    //查询所有的用户
    Flux<User> getAllUser();

    //保存用户信息
    Mono<Void> saveUserInfo(Mono<User> user);
}
