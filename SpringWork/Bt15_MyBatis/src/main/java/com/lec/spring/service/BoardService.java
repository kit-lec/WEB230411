package com.lec.spring.service;

import com.lec.spring.domain.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardService {
    // 글 작성
    int write(Post post);

    // 특정 id 의 글 조회
    // 트랜잭션 처리
    // 1. 조회수 증가 (UPDATE)
    // 2. 글 읽어오기 (SELECT)
    @Transactional
    // <- 이 메소드를 트랜잭션으로 처리
    Post detail(long id);

    // 글 목록
    List<Post> list();

    // 특정 id 의 글 읽어오기 (SELECT)
    // 조회수 증가 없슴
    Post selectById(long id);

    // 특정 id 글 수정하기 (제목, 내용) (UPDATE)
    int update(Post post);

    // 특정 id 의 글 삭제하기 (DELETE)
    int deleteById(long id);
}
