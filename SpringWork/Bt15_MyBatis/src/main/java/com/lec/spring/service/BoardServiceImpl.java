package com.lec.spring.service;

import com.lec.spring.domain.Post;
import com.lec.spring.repository.PostRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Service
// - 비즈니스 로직
// - 트랜잭션
@Service
public class BoardServiceImpl implements BoardService {

    private PostRepository postRepository;

    @Autowired
    public BoardServiceImpl(SqlSession sqlSession){    // MyBatis 가 생성한 SqlSession bean 객체 주입
        postRepository = sqlSession.getMapper(PostRepository.class);
        System.out.println(getClass().getName() + "() 생성");
    }

    // 글 작성
    @Override
    public int write(Post post){   // post 안에는 name, subject, content 가 담겨 있다.
        // DB 에 저장 -> repository
        return  postRepository.save(post);
    }

    // 특정 id 의 글 조회
    // 트랜잭션 처리
    // 1. 조회수 증가 (UPDATE)
    // 2. 글 읽어오기 (SELECT)
    @Override
    @Transactional   // <- 이 메소드를 트랜잭션으로 처리
    public Post detail(long id){
        postRepository.incViewCnt(id);
        Post post = postRepository.findById(id);
        return post;
    }

    // 글 목록
    @Override
    public List<Post> list(){
        return postRepository.findAll();
    }

    @Override
    public Post selectById(long id) {
        return null;
    }

    @Override
    public int update(Post post) {
        return 0;
    }

    @Override
    public int deleteById(long id) {
        return 0;
    }

}




