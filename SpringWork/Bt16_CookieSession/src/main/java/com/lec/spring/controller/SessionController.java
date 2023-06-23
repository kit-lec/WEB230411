package com.lec.spring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@Controller
@RequestMapping("/session")
public class SessionController {


    // HttpSession 객체
    //  현재 request 한 client 에 대한 Session 정보
    @RequestMapping("/list")
    public void list(HttpSession session, Model model){

        // 세션에 있는 '모든' name(들) 추출
        Enumeration<String> enumeration = session.getAttributeNames();

        StringBuffer buff = new StringBuffer();
        int i = 0;
        while(enumeration.hasMoreElements()){
            String sessionName = enumeration.nextElement();
            // value 추출
            String sessionValue = session.getAttribute(sessionName).toString();
            buff.append((i + 1) + "] " + sessionName + " : " + sessionValue + "<br>");
            i++;
        }
        if(i == 0){
            buff.append("세션안에 attribute 가 없습니다 <br>");
        }

        model.addAttribute("result", buff.toString());
    }

    @RequestMapping("/create")
    public String create(HttpSession session){
        String sessionName, sessionValue;

        sessionName = "num1";
        sessionValue = "" + (int)(Math.random() * 100);

        // setAttribute(String name, Object value);
        session.setAttribute(sessionName, sessionValue);

        sessionName = "datetime";
        sessionValue = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        session.setAttribute(sessionName, sessionValue);

        return "redirect:/session/list";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session){
        // 세션 attribute 삭제
        session.removeAttribute("num1");
        return "redirect:/session/list";
    }


    // 과제: Session 인증
    //-------------------------------------------------
    public static final String ADMIN_ID = "admin";
    public static final String ADMIN_PW = "1234";

    @GetMapping("/login")
    public void login(HttpSession session, Model model){
        // 현재 로그인 상태인지, 즉 로그인 세션 (name이 'userid'인 세션값)이 있는지 확인
        if(session.getAttribute("userid") != null){
            model.addAttribute("userid", session.getAttribute("userid"));
        }
    }

    @PostMapping("/login")
    public String loginOk(String userid, String pw, HttpSession session
            , Model model){

        // 세션 name-value 지정
        String sessionName = "userid";
        String sessionValue = userid;

        // 제출된 id /pw 값이 일치하면 로그인 성공 + 세션 attr 생성
        if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
            session.setAttribute(sessionName, sessionValue);
            model.addAttribute("result", true);
        }else{
            session.removeAttribute(sessionName);
        }

        return "session/loginOk";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){

        String sessionName = "userid";

        // 세션 삭제
        session.removeAttribute(sessionName);

        return "session/logout";
    }

}
