package com.lec.java.firstjava;

/*
    block comment(블럭주석)
    모든 자바 프로그램은 main() 메소드로부터 '시작'한다
    프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
    문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/

// line comment(한줄 주석)   // 우측의 입력한 텍스트는 모두 주석 처리
// 프로그램 실행과는 상관 없지만,
// 개발자가 프로그램을 작성할 때 설명을 달아주는 것

public class FirstJava {

    public static void main(String[] args) {

        System.out.println(10 + 20);
        System.out.println("10 + 20");

        System.out.println(11 + 32 + 100);



        System.out.println("안녕하세요," + " + " + "여러분");

        // "문자열" + 숫자 => 문자열
        //           ↓ 문자열 변환
        // "문자열" + "숫자" => 문자열

        System.out.println("결과: " + 10);
        System.out.println("결과: " + 10 + 20);
        System.out.println("결과: " + (10 + 20));

        System.out.println(3.14);  // 소숫점이 있으면 '실수' ,  소숫점이 없으면 '정수'
        System.out.println(0.12);
        System.out.println(.12);
        System.out.println(14);  // 정수
        System.out.println(14.); // 실수

        // 사칙연산
        System.out.println("10 + 20 = " + (10 + 20));
        System.out.println("10 - 20 = " + (10 - 20));
        System.out.println("10 * 20 = " + (10 * 20));
        System.out.println("10 / 20 = " + (10 / 20));  // 정수와 정수의 연산결과는 정수  (소숫점 이하 절삭된 결과)
        System.out.println("10.0 / 20.0 = " + (10.0 / 20.0)); // 실수와의 연산결과는 실수.
        System.out.println("10 / 20.0 = " + (10 / 20.0));
        System.out.println("10.0 / 20 = " + (10.0 / 20));

        // (double)10 => 10이라는 정수를 10.0 실수로 변환
        System.out.println("10 / 20 = " + ((double)10 / 20));

        // She says "Hi"  <-- 출력하려면?
        System.out.println("She says \"Hi\"");

        // 이스케이프 문자 (escape character)
        // " ~ " 문자열 안에서 특수 문자 출력

        // 입문시 기억할만한 이스케이프 문자
        // \"  : 쌍따옴표
        // \n  : 줄바꿈
        // \t  : 탭문자
        // \\  : 문자열 안에서 역슬래시 출력

        System.out.println("123\t456\t7890");
        System.out.println("12\t34\t56\t78\t90");
        System.out.println("12345\t67890");
        System.out.println("John \nWick");

        System.out.println("\n프로그램 종료");
    } // end main()

} // end class











