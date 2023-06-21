package com.lec.spring.controller;


import com.lec.spring.domain.Post;
import com.lec.spring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    public BoardController(){
        System.out.println(getClass().getName() + "() 생성");
    }

    @GetMapping("/write")
    public void write(){}

    @PostMapping("/write")
    public String writeOk(
            @ModelAttribute("post") Post post, Model model){

        int write = boardService.write(post);
        model.addAttribute("result", write);

        return "board/writeOk";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable long id, Model model){
        model.addAttribute("post", boardService.detail(id));
        return "board/detail";
    }

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("list", boardService.list());
    }


}




