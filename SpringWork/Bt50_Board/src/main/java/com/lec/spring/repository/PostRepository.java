package com.lec.spring.repository;

import com.lec.spring.domain.Post;

import java.util.List;

public interface PostRepository {

    // 새글 작성(INSERT) <- Post
    int save(Post post);

    // 특정 id 글 내용 읽기 (SELECT)
    // 만약 해당 id 의 글 없으면 null 리턴함
    Post findById(long id);

    // 특정 id 글 조회수 +1 증가 (UPDATE)
    int incViewCnt(long id);
    
    // 전체 글 목록 : 최신순  (SELECT)
    List<Post> findAll();

    // 특정 id 글 수정 (제목, 내용) (UPDATE)
    int update(Post post);

    // 특정 id 글 삭제 (DELETE)
    int delete(Post post);

    // 페이징
    // 전체 글의 개수
    int countAll();

    List<Post> selectFromRow(int from, int rows);  // from 부터 rows 개 만큼 select

}














