package com.lec.spring.controller2;

import com.lec.spring.common.U;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class BaseController {

    @RequestMapping("/member/search")
    public void searchMember(){
        System.out.println("searchMember() 호출");
    }

    // ModelAndView 객체 사용
    // '뷰(View)' 와 '데이터(Model)' 을 둘다 -> ModelAndView 에 세팅
    @RequestMapping("/member/find")
    public ModelAndView findMember(){
        ModelAndView mv = new ModelAndView();
        // Model
        mv.addObject("mbName", "루피");
        mv.addObject("mbDate", LocalDateTime.now());

        // View
        mv.setViewName("member/find");

        return mv;
    }

    @RequestMapping("/member/action/*")
    @ResponseBody
    public String memberAction1(HttpServletRequest request) {
        return U.requestInfo(request);
    }

    @RequestMapping("/member/action/*/*")
    @ResponseBody
    public String memberAction2(HttpServletRequest request) {
        return U.requestInfo(request);
    }

    @RequestMapping("/member/action/*/*/**")
    @ResponseBody
    public String memberAction3(HttpServletRequest request) {
        return U.requestInfo(request);
    }
    
    // 확장자 패턴
    @RequestMapping("/member/*.do")
    // @RequestMapping("/member/**/*.do")
    @ResponseBody
    public String doMember(HttpServletRequest request) {
        return U.requestInfo(request);
    }


}
