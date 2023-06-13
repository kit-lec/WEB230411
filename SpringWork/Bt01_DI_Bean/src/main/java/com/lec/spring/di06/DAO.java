package com.lec.spring.di06;

import lombok.ToString;
import org.springframework.stereotype.Repository;

public interface DAO {
}

@ToString
@Repository
class DAOImpl implements DAO{
    public DAOImpl() {
        System.out.println("DAIImpl() 생성");
    }
}