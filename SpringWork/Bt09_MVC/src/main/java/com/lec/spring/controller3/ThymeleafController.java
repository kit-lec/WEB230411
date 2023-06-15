package com.lec.spring.controller3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("sample01")
    public void sample01(Model model){
        model.addAttribute("greeting", "Hello Thymeleaf");
        model.addAttribute("date", LocalDate.now());
    }

    /*********************************************************
     * Standard Expression Syntax
     *      - Literals
     *      - Variable Expressions: ${...}
     */
    @GetMapping("/sample02")
    public void sample02(Model model){}

    /**************************************************************
     * Conditional expressions
     *      If-then:(if) ? (then)
     *      If-then-else: (if) ? (then) : (else)
     *         Default: (value) ?: (defaultvalue)
     */

    @GetMapping("/sample03")
    public void sample03(Model model){
        model.addAttribute("num1", 22);
        model.addAttribute("num2", 0);
        model.addAttribute("num3", "");
        model.addAttribute("num4", null);
    }

}


