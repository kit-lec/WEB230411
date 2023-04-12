package com.lec.java.hello;

public class Hello {

    // comment (주석)
    public static void main(String[] args) {   // <- main method.  Java 프로그램의 시작점(entry point)
        
        // main 메소드 안의 statement(문) 들을 차례대로 수행 
        
        System.out.println("Hello Java!");  // System.out.println(...)  (..) 안의 내용을 화면에 출력하고 줄바꿈 (line)
        System.out.println("안녕하세요 자바");
        System.out.println("나 자바바라~");

        System.out.println();
        System.out.println();

        System.out.println(1 + 2);    // 숫자 + 숫자 <- 산술연산

        // 문자열: " ~ "
        System.out.println("1" + "2");  // 문자열 + 문자열 <- 문자열 연결 연산

        // print() <- 화면에 출력 (줄바꿈 안함)
        System.out.print("Good morning");
        System.out.print("Korea");

        System.out.println("좋은 아침");
        
        
        // 마지막 statement 실행이 끝나면 프로그램 종료
    }

}











