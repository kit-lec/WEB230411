package com.lec.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    public BoardController(){
        System.out.println(getClass().getName() + "() 생성");
    }
    
}




