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

    // 특정 id 의 글 읽어오기 (SELECT)
    // 조회수 증가 없슴
    @Override
    public Post selectById(long id) {
        Post post = postRepository.findById(id);
        return post;
    }

    // 특정 id 글 수정하기 (제목, 내용) (UPDATE)
    @Override
    public int update(Post post) {
        return postRepository.update(post);
    }

    // 특정 id 의 글 삭제하기 (DELETE)
    @Override
    public int deleteById(long id) {
        int result = 0;

        Post post = postRepository.findById(id);
        if(post != null){
            result = postRepository.delete(post);
        }

        return result;
    }

}




