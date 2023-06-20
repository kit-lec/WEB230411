package com.lec.spring.controller4;

import com.lec.spring.domain.Post;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/delete")    // <-  /user/delete
    public void delMember(HttpServletRequest request, Model model){
        String id = request.getParameter("id");   // "id" 란 name 의 parameter 값 리턴 (String)
        System.out.println("id = " + id);

        String age = request.getParameter("age");  // 만약 해당 name 의 paramter 가 없으면 null 리턴
        System.out.println("age = " + age);

        model.addAttribute("mbId", id);
        model.addAttribute("mbAge", age);

        // 동일한 name 의  parameter 가 여러개인 경우
        String [] arrNum = request.getParameterValues("num");   // String[] 리턴
        System.out.println("arrNum = " + Arrays.toString(arrNum));
    }

    @GetMapping("/regist")
    public void registMember(){}

    @PostMapping("/regOk")
    public void regOk(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        model.addAttribute("username", username);
    }

    // ---------------------------------------------------
    // parameter name 값과 동일한 이름의 매개변수를 핸들러에 지정해서 받아오기
    @RequestMapping("/find1")
    //public void find1(String id, String name, Model model){
    public void find1(String name, Model model, String id){  // 매개변수 순서 무관.
        System.out.println("user/find1 : id=" + id + ", name=" + name);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
    }

    // 숫자 타입은 바로 parsing 하여 받을수도 있다.
    @RequestMapping("/find2")
    //public void find2(double id, String name){ // primitive 타입인데, parameter 에 없는 경우, 혹은 parsing 불가능하면 에러 발생
    public void find2(Double id, String name){ // wrapper 타입이면, parameter 없으면 null 값으로 받아옴. parsing 불가하면 에러
        System.out.println("user/find2 : id=" + id + ", name=" + name);
    }
    
    // parameter 를 특정 타입의 자바객체로 변환하여 받아내는 것을 'binding' 한다고 한다

    // 동일한 name 의 parameter(들) --> "배열" 매개변수로 받을수 있다
    @RequestMapping("/find3")
    public void find3(int [] id, String [] name){
        System.out.println("user/find3 : id=" + Arrays.toString(id) + ", name=" + Arrays.toString(name));
        // /user/find3?id=10&id=20&id=30&name=aaa&name=bbb
    }

    // 만약 request parameter 의 name 과 매개변수가 같을수 없는 상황이면
    // @RequestParam 애노테이션 사용
    @RequestMapping("/find4")
    public void find4(
            @RequestParam("id") String userid,
            @RequestParam("name") String username){

        System.out.println("user/find4 : id=" + userid + ", name=" + username);

    }

    // 위의 경우 id 값이 없거나 변환 불가능하면 에러 발생한다. (왜냐하면 @RequestParam 의 required=true 이기 때문이다)
    // @RequestParam(value="test", required=false, defaultValue="0") 을 이용하면 가능하긴 하다.
    // 또한, @RequestParam 과 Map<name, value> 을 사용하면 된다.
    @RequestMapping("/find5")
    public void find5(@RequestParam Map<String, String> map){
        System.out.println("user/find5: " + map);
    }

    //----------------------------------------------------
    // 커맨드 객체 (Command object) 사용

    @GetMapping("/write")
    public void writeBoard(){}

    // 기존의 방식대로라면
    // 매 parameter 들을 매개변수화 하는 것은 힘들다.

//    @PostMapping("/writeOk")
//    public void writeOkBoard(
//            String name
//            , String subject
//            , String content
//    ){
//
//    }

    // 커맨드 객체 사용
    // 코드 작업량이 매우 줄어든다.

    // 커맨드 객체는 기본적으로 '객체타입명'으로 Model attribute 추가 된다. (소문자로)
    // Model attribute name 을 바꿀경우 @ModelAttribute 로 지정

    @PostMapping("/writeOk")
    public void writeOkBoard(@ModelAttribute("DTO") Post post){
        System.out.println("/writeOk: " + post);
    }

/**
 * @PathVariable 사용
 *
 *  request url 을 통해 parameter 를 받는 방법은 다음 방법들이 있다
 *   /API_NAME?key1=val1   <-- query string 사용
 *   /API_NAME/{value1}    <-- path variable 사용
 */

    @RequestMapping("/writePath/{name}/{subject}/{k3}")
    public String writePathBoard(
            @PathVariable String name
            , @PathVariable String subject
            , @PathVariable(name = "k3") String content
            , Model model
    ){
        System.out.println("/user/writePath/name =" + name + "/subject =" + subject + "/content =" + content);

        model.addAttribute("name", name);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);

        return "user/writePath";
    }

    //-----------------------------------------------------
    // redirect

    @RequestMapping("/ageInput")
    public void ageInput(){}

    @RequestMapping("/ageCheck")
    public String chkAge(int age
            , RedirectAttributes redirectAttributes){   // redirect 되는 request 에 보낼 parameter 지정

        redirectAttributes.addAttribute("age", age);

        if(age < 19){
            return "redirect:/user/underAge";   // view 를 response 하는게 아니라 redirect 한다!
        } else {
            return "redirect:/user/adult";
        }
    }

    @RequestMapping("/underAge")
    public String pageUnderAge(@ModelAttribute("age") int age){
        return "user/ageUnder";
    }

    @RequestMapping("/adult")
    public String pageAdult(int age){
        return "user/ageAdult";
    }

    //---------------------------------------------------
    // forward:
    @RequestMapping("/detail")
    public String memberDetail(){
        System.out.println("/user/detail 요청");
        return "forward:/user/notfound";
    }

    @RequestMapping("/notfound")
    @ResponseBody
    public String memberNotFound(){
        System.out.println("/user/notfound 요청");
        return "/user/notfound";
    }

}










