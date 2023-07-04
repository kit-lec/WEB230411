package com.lec.spring.controller;

import com.lec.spring.domain.QryCommentList;
import com.lec.spring.domain.QryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // data 를 response 한다
@RequestMapping("/comment")
public class CommentController {
    
    public CommentController(){
        System.out.println(getClass().getName() + "() 생성");
    }

    @GetMapping("/test1")
    public String test1(){
        return "Hello";
    }

    @GetMapping("/test2")
    public QryResult test2(){
        return QryResult.builder()
                .count(34)
                .status("OK")
                .build();
    }

    @GetMapping("/test3")
    public QryCommentList test3(){
        QryCommentList list = new QryCommentList();
        list.setCount(1);
        list.setStatus("FAIL");
        return list;
    }
    
}









