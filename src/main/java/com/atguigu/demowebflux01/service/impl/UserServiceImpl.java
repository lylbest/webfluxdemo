package com.atguigu.demowebflux01.service.impl;

import com.atguigu.demowebflux01.entity.User;
import com.atguigu.demowebflux01.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


   private final Map<Integer,User> users=new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("lucy", "nan", 15));
        this.users.put(2, new User("mary", "nv", 18));
        this.users.put(3, new User("jack", "nan", 21));


    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> user) {

        user.doOnNext(person->{
            int id=users.size()+1;
            users.put(id,person);
        }).thenEmpty(Mono.empty()); //清空，表示终止

        return null;
    }
}
