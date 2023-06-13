package com.lec.spring.di06;

import org.springframework.stereotype.Repository;

public interface UserRepository {
}

@Repository
class UserRepositoryImpl implements  UserRepository{
    public UserRepositoryImpl(){
        System.out.println("UserRepositoryImpl() 생성");
    }
}