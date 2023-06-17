package com.lec.spring.controller3;

import com.lec.spring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    //--------------------------------------------------------
    // 데이터 준비
    String [] arr1 = new String[]{"AAA", "BBB", "CCC", "DDD", "EEE"};
    Member[] arr2;
    List<Integer> list1 = new ArrayList<>();
    List<Member> list2 = new ArrayList<>();

    Map<Integer, String> map1 = new HashMap<>();
    Map<String, Member> map2 = new HashMap<>();

    public ThymeleafController(){
        System.out.println(getClass().getName() + "() 생성");

        Member member;
        // 데이터 초기화
        for(int i = 0; i < 5; i++) {
            list1.add(i * 1000);
            member = new Member(100 + i, "u0" + i, "p0" + i, arr1[i],
                    LocalDateTime.now());
            list2.add(member);
            map1.put(i, arr1[i]);
            map2.put(arr1[i], member);
        }
        arr2 = list2.toArray(new Member[5]);

        // 확인해보기
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        System.out.println("map1: " + map1);
        System.out.println("map2: " + map2);

    } // end 생성자


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

    /* *****************************************************
     * Variable Expressions: ${...}
     *   . (dot) 을 사용하여 접근
     *
     *   1. Object 변수의 .property → 해당 Object 의 property 접근 (getter 호출값)
     *         없는 property 는 에러
     *   2. 배열, List<> 변수의 [index] →  index 번째의 item 값
     *          없는 index 는 에러
     *   3. Map<k,v> 변수의 .key →  Map 의 value 값
     *          없는 key 는 에러
     */
    @GetMapping("/sample03")
    public void sample03(Model model){
        model.addAttribute("num1", 22);
        model.addAttribute("num2", 0);
        model.addAttribute("num3", "");
        model.addAttribute("num4", null);

        System.out.println(model.addAttribute("arr1", arr1));
        System.out.println(model.addAttribute("arr2", arr2));
        System.out.println(model.addAttribute("list1", list1));
        System.out.println(model.addAttribute("list2", list2));
        System.out.println(model.addAttribute("map1", map1));
        System.out.println(model.addAttribute("map2", map2));

    }

    /* ***************************************************************
     * Iteration
     *      th:each 를 사용하여
     *       배열, List<>, Set<>, Map<k,v>
     *      https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#iteration
     *
     *      Conditional Evaluation
     *      th:if   th:unless
     *      https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#conditional-evaluation
     */

    @GetMapping("/sample04")
    public void sample04(Model model) {
        model.addAttribute("list", list2);


        list2.get(3).setId(null);
        model.addAttribute("list2", list2);

        model.addAttribute("map2", map2);   // <String, Member>

        // th:if 에서 어케 판정될까?
        model.addAttribute("test1", "aaa");
        model.addAttribute("test2", "");
        model.addAttribute("test3", null);
        model.addAttribute("test4", false);


    }

    /* *********************************************************************
     * Inlining
     *  기본적으로 thymeleaf 는 tag attribute 에 지정해서 동작하나,  직접 HTML 에 작성하는 inline 방식도 제공합니다
     *  https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#inlining
     *
     * 4가지 종류의 inline ↓
     *
     *  1. Expression inlining
     *     [[...]] ← th:text 와 같은 동작
     *     [(...)] ← th:utext 와 같은 동작
     *  2. Text inlining →  th:inline="text"
     *  3. JavaScript inlining → <script th:inline="javascript">
     *  4. CSS inlining → <style th:inline="css">
     */
    @GetMapping("/sample05")
    public void sample5(Model model){
        String result = "SUCCESS";
        model.addAttribute("result", result);
    }

    /****************************************************
     * Expression Utility Objects (표현식 유틸 객체)
     * https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#expression-utility-objects
     *
     * #temporals  <- java.time.* 객체를 다룸.
     * #dates  <- java.util.Date 객체 의 메소드 사용 가능
     * #calendars  <- java.util.Calendar 객체 의 메소드 사용 가능
     * #numbers    #strings     #objects
     * #bools
     * #arrays     #lists     #sets     #maps
     * #aggregates    #messages
     */

    @GetMapping("/sample06")
    public void sample6(Model model){
        model.addAttribute("now1", LocalDateTime.now());    // java.time.LocalDateTime
        model.addAttribute("now2", new Date());   // java.util.Date
        model.addAttribute("price", 123456789);
        model.addAttribute("title", "This is sample");
        model.addAttribute("options", Arrays.asList("AAAA", "BBB", "CCC", "DDD"));  // List<>
    }

    // TODO

}


