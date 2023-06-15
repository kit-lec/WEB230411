package com.lec.spring.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *  일반적인 url 구성은
 *     /{controller}/{action} <- 이와 같은 방식으로 구성하곤 한다
 *
 *    - 그리고, 특정 도메인에 대한 동작을 특정 controller 에 전담하여 설계하는게 일반적
 *      ex)  /member/find, /member/do, /memeber/list
 *           => MemberController 가 담당!
 *
 *    - 매 url 마다 서두에 반복되는  "/member" 를 handler 가 아닌 controller 에 지정 가능
 */
@Controller
@RequestMapping("/member") // <- 이 컨트롤러는 "/member" 로 시작하는 url 에 매핑된다.
public class MemberController {

    @RequestMapping("/save")  // URL mapping =>  /member + /save => /member/save
    public String saveMember(){
        return "member/save";
    }

    @RequestMapping("/load") //  => /member/load
    public void loadMember(){
        // return "member/load" 와 동일
    }

    // url mapping 중복되면 에러!  <- 서버 가동할때 에러!
//    @RequestMapping("/search")  // => /member/search
//    public void searchMember(){}

}
