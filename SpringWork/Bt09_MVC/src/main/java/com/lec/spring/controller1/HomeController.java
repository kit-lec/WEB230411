package com.lec.spring.controller1;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
     Controller
      - '어떠한 request' 를 받아서,
      - '어떠한 비스니즈 로직 (business logic)' 을 처리하고 하고
      - '어떠한 response' 를 할지를 정의
*/
@Controller  // Spring MVC 에선 Controller 역할을 하는 bean 객체로 생성
public class HomeController {

    public HomeController(){
        System.out.println(getClass().getName() + "() 생성합니다");
    }

    /*
    '어떠한 url' 의 request 처리를
    '어떠한 controller' 의 '어떤 handler' 에게 전달하는 것을
    'Routing' 이라 한다!   (웹 프레임워크의 가장 기본적인 기능)
        url => controller => handler

    ※ Routing, 혹은 Request Mapping, 혹은 Url Mapping 이라고도 불린다.
*/

    @RequestMapping("/") //  "/" 라는 url 로 request 가 들어오면 아래 메소드가 처리(handle) 한다
    public String now(Model model){ // Model: 데이터를 실어나르는 객체, View 로 전달됨!
        System.out.println("now() 호출됨");

        LocalDateTime t = LocalDateTime.now();

        // ↓ Model 에 데이터 담기. addAttribute(name, value)
        //  name 은 String,  value 는 Object
        model.addAttribute("serverTime", t);
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 29);

        // String 을 리턴하는 handler!
        // view 리턴 -> ViewResolver 를 통해 template engine에 전달
        return "home";

        // "templates/views/" + "home" + ".html"
        // "templates/views/home.html"
    }

    // 동일 url 처리하는 handler 중복 작성 불가
//    @RequestMapping("/")
//    public String abcd(){
//        return null;
//    }

    /*
     ViewResolver는 view 파일을 찾아낸다.  (view 파일을 template 이라고 한다)
     prefix + "home" + suffix =>
     "templates/views/" + "home" + ".html"    (Spring

     View Resolver 가 선택한 '템플릿 파일'과 'Model 데이터'는
     설정된 Template Engine 에 넘겨진다 (ex: Thymeleaf, Mustache..)

     템플릿 엔진이 '템플릿파일' + '데이터'를 조립하여 response 할 데이터 생성
     위 생성된 결과가 결국 response 된다.
*/


    /*
    static 리소스들
      별도의 서버측 처리 없이 파일 그대로 response 되는 리소스들
      Spring MVC 에선 기본적으로 resources/static 폴더를
      static 리소스 루트로 삼는다

     ※ static 경로는 추가, 변경 가능하다.
 */

    @RequestMapping("/aaa")
    public String home(Model model){
        int a = new Random().nextInt(10);
        int b = new Random().nextInt(5);

        model.addAttribute("first", a);
        model.addAttribute("second", b);

        return "aaa/my";

        // prefix + "aaa/my" + postfix  ???
        // => templates/views/ + "aaa/my" + ".html"
        // => templates/views/aaa/my.html


    }

    // 핸들러 이름은 그닥 중요하진 않다.
    // ※ 그러나 가급적,
    //   'request url' - 'handler 이름' - 'view 이름'은
    //    같거나 동일한 맥락으로 일치시켜주는게 덜 헷갈리고 코드 가독성에 좋다.

    //   /read  -> read() ->  read.html
    @RequestMapping("/aaa/bbb")
    public String aaabbb(Model model){
        int a = new Random().nextInt(10);
        int b = new Random().nextInt(5);
        model.addAttribute("first", a);
        model.addAttribute("second", b);

        return "aaa/bbb/title";  // ->   "templates/view/" + "aaa/bbb/title" + ".html"
    }

    // void 를 리턴하는 handler
    // 기본적으로 request url 과 같은 view 를 response 한다.
    // (일반적으로 많이 사용)

    @RequestMapping("/aaa/bbb/ccc")
    public void aaabbbccc(){
// templates/views/ + "aaa/bbb/ccc" + ".html"
    }

    // HttpServletRequest (aka. request객체)
    //    request 에 대한 정보는 HttpServletRequest 객체를 통해 읽을수 있다.
    //       (url, parameter, cookie, session, header...)
    //    이는 handler 의 매개변수로 설정해놓으면 request 시 spring container 가 전달해준다.

    @RequestMapping("/aaa/bbb/HttpServletRequest")
    public void httpServletRequest(Model model, HttpServletRequest request){
        String method = request.getMethod();  // GET, POST ...
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();

        // WAS 의 경로
        // http://domain/context-path/....
        String conPath = request.getContextPath();

        String uri = request.getRequestURI();
        String reqPath = uri.substring(conPath.length());
        String url = request.getRequestURL().toString();

        String queryString = request.getQueryString();
        String name= request.getParameter("name");
        String age = request.getParameter("age");


        model.addAttribute("method", method);
        model.addAttribute("scheme", scheme);
        model.addAttribute("serverName", serverName);
        model.addAttribute("serverPort", serverPort);
        model.addAttribute("conPath", conPath);
        model.addAttribute("uri", uri);
        model.addAttribute("reqPath", reqPath);
        model.addAttribute("queryString", queryString);
        model.addAttribute("name", name);
        model.addAttribute("age", age);

    }


    //------------------------------------------------------------
    // @ResponseBody
    //   자바 객체를 그대로 response 함 (view 를 사용하지 않음)
    //   String 을 리턴하면 문자열 텍스트로 response
    //   Java 객체를 리턴하면 JSON 으로 response
    @RequestMapping("/ccc")
    @ResponseBody
    public String ccc() {
        return "/ccc";
    }

    @RequestMapping("/ccc2")
    @ResponseBody
    public String ccc2(){
        StringBuffer buff = new StringBuffer();
        buff.append("<h1>Hello Spring</h1>");
        buff.append("<h3>Spring Boot</h3>");
        return buff.toString();
    }

    @RequestMapping("/ddd")
    @ResponseBody
    public List<Integer> ddd(){
        return List.of(10, 20, 30);    // List<>, Set<>, 배열 => JSON arrray 로 변환
    }

    @RequestMapping("/eee")
    @ResponseBody
    public Map<String, Integer> eee(){
        // Map<>, Java Object => JSON object 로 변환
        return Map.of("국어", 100, "영어", 72, "수학", 81);
    }

    @Data
    @AllArgsConstructor
    class Product {
        private int no;
        private String name;
        private boolean sold;

        public String getAddress(){
            return "역삼동";
        }
    }

    @RequestMapping("/fff")
    @ResponseBody
    public Product fff(){
        return new Product(10, "자전거", false);
    }


    // TODO


}  //  end controller











