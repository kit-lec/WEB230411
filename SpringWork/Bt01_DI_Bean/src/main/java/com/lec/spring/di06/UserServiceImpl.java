package com.lec.spring.di06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(){
        System.out.println("UserService() 생성");
    }

    public void test1(){

    }

    public void test2(int num, String name){

    }
}
