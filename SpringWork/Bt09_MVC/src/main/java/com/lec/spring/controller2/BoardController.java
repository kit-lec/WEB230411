package com.lec.spring.controller2;


// https://docs.google.com/presentation/d/1o5nuK5tNS-aeTMSuiS46D5Yi47Z6YUhyPAMjfmGraS4/edit#slide=id.g1d6a3e2c5f8_0_532

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {


    @RequestMapping("/list")   // request -->  /board/list
    public void listBoard() {}

    @RequestMapping("/write")
    public void writeBoard(){
    }

    @RequestMapping("/detail")  // request --> /board/detail
    public void detailBoard() {

    }

    @RequestMapping("/update")
    public void updateBoard() {

    }

    @RequestMapping("/delete")
    public void deleteBoard() {

    }

}
