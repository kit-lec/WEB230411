package com.lec.spring.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/cookie")
public class CookieController {

    @RequestMapping("/list")
    public void list(HttpServletRequest request, Model model){
        // 클라이언트 안의 쿠키 정보는 request 시에 서버로 전달된다.
        // request.getCookies() 로 쿠키 받아올수 있다.

        // jakarta.servlet.http.Cookie
        Cookie[] cookies = request.getCookies();

        StringBuffer buff = new StringBuffer();

        if(cookies != null){ // 쿠키가 하나도 없다면 null 이 리턴된다.
            for(int i = 0; i < cookies.length; i++){
                // Cookie 는 name-value 쌍으로 이루어진 데이터 (name, value 는 모두 String)
                String name= cookies[i].getName();  // 쿠키 '이름'
                String value = cookies[i].getValue();  // 쿠키 '값'
                buff.append((i + 1) + "]" + name + " : " + value + "<br>");
            }
        } else {
            buff.append("쿠키가 없습니다<br>");
        }

        model.addAttribute("result", buff.toString());
    }

    // 쿠키 생성 절차
    //1. 쿠키(Cookie) 클래스로 생성
    //2. 쿠키속성 설정(setter)
    //3. 쿠키의 전송 (response 객체에 탑재:addCookie())
    @RequestMapping("/create")
    public String create(HttpServletResponse response){
        String cookieName1 = "num1";
        String cookieValue1 = "" + (int)(Math.random() * 10);

        Cookie cookie1 = new Cookie(cookieName1, cookieValue1);  //  name-value 쌍
        cookie1.setMaxAge(30);    // 쿠키 파기(expiry) 시간 설정 (생성시점으로부터 30초 뒤에 파기)

        response.addCookie(cookie1);  // response 에 cookie 추가

        String cookieName2 = "datetime";
        String cookieValue2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));   // '-', ':' 등의 문자는 쿠키에 사용 못함
        Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
        cookie2.setMaxAge(60);
        response.addCookie(cookie2);

        return "redirect:/cookie/list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletResponse response){
        String cookieName = "num1";  // 삭제될 cookie 의 name
        Cookie cookie = new Cookie(cookieName, "xxx");
        cookie.setMaxAge(0);  // response 되자마자 해당 name 의 cookie 는 삭제됨
        response.addCookie(cookie);

        return "redirect:/cookie/list";
    }

    //------------------------------------------------------------------------
    public static final String ADMIN_ID = "admin";
    public static final String ADMIN_PW = "1234";

    @GetMapping("/login")
    public void login(@CookieValue(name="username", required = false) String userid, Model model){
        model.addAttribute("userid", userid);
    }

    @PostMapping("/login")
    public String loginOk(String userid, String pw, HttpServletResponse response, Model model){
        // userid / pw 일치하면 로그인 성공 + 쿠키 생성
        if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
            Cookie cookie = new Cookie("username", userid);
            cookie.setMaxAge(30);
            response.addCookie(cookie);

            model.addAttribute("result", true);
        } else {
            Cookie cookie = new Cookie("username", userid);
            cookie.setMaxAge(0);  // 기존의 쿠키도 죽인다.
            response.addCookie(cookie);
        }

        return "cookie/loginOk";
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);  // 기존의 쿠키도 죽인다.
        response.addCookie(cookie);

        return "cookie/logout";
    }



}




