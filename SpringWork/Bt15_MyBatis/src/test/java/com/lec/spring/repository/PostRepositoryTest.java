package com.lec.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest   // 스프링 context 를 로딩하여 테스트에 사용
class PostRepositoryTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    void test1(){
        PostRepository postRepository = sqlSession.getMapper(PostRepository.class);
        postRepository.incViewCnt(1L);
        System.out.println(postRepository.findById(1L));
        System.out.println("테스트 완료");
    }

    @Test
    void test2(){
        PostRepository postRepository = sqlSession.getMapper(PostRepository.class);
        System.out.println(postRepository.findAll());
    }

}










