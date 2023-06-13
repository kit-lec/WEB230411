package com.lec.spring.di06;

import org.springframework.stereotype.Controller;

@Controller
public class BoardController {

    DoService service;

    // DoService bean 을 주입받아 생성
    public BoardController(DoService service){
        System.out.println("BoardController(" + service + ") 생성");
        this.service = service;
    }

}
