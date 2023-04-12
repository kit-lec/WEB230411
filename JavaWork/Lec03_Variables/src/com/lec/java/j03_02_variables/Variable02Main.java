package com.lec.java.j03_02_variables;

/*
    변수명 등 사용자가 이름을 지어준것들 --> 식별자 (identifier) 라고 함.

    식별자 수정할때는 refactor 기능을 활용하자.
 */
public class Variable02Main {

    public static void main(String[] args) {
        
        // 변수 선언과 동시에 초기화
        int num1 = 10;
        
        // 여러개의 변수 한번에 선언
        int a, b, c;  // int 타입 변수 3개 선언

        int kor = 50, eng = 33, math = 78;

        // 총점
        System.out.println("총점: " + (kor + eng + math));

        int total = kor + eng + math;
        // 평균
        System.out.println("평균: " + (total / 3));
        System.out.println("평균: " + (total / 3.0));

        // 변수명 바꿀때는 refactor-rename 사용하자!   SHIFT+F6

        // 변수명 (식별자) 작명 제약사항.
        // 알파벳, 숫자, _, $
        // 숫자로 시작하면 안됨
        // 띄어쓰기 안됨
        // 대소문자 구분
        // 중복 안됨.
        int abc;
//        int abc;  // 중복선언 불가

        int Abc;
        int year2020;
        //int 2020year;   // 숫자로 시작하면 안됨.

        // 일반적으로 지역변수는 소문자로 시작
        int myLittleToy;  // 자바에선 일반적으로 변수명은 camel-notation 따름
        int my_little_toy;
        int _my_toy_;
        int $aa;

//        int a#;

    } // end main
} // end class







