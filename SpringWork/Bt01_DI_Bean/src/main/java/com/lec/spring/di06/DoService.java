package com.lec.spring.di06;

import lombok.ToString;
import org.springframework.stereotype.Service;

public interface DoService {
}

@ToString
@Service
class RegisterService implements DoService{

    DAO dao;

    public RegisterService(DAO dao){
        System.out.println("RegisterService(" + dao +") 생성");
        this.dao = dao;
    }

}