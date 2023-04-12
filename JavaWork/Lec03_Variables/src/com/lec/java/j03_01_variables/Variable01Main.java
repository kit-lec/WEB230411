package com.lec.java.j03_01_variables;
/*
 * 	변수 (Variables) :
 * 		값을 담는 공간.  변수이름(variable name)을 부여해서 관리
 *
 * 	변수는 사용하기 전에 먼저 '선언(declaration)' 해야 한다
 *	변수 선언 구문:
 *		변수타입 변수이름;
 *
 *	변수의 초기화 (initialization)
 *		변수에 최초로 값(value) 을 대입 (assignment) 하는 것.
 *		변수(지역변수)를 사용/참조하려면 그전에 반드시 초기화가 되어야 함.
 *
 */
public class Variable01Main {

    public static void main(String[] args) {

        // 변수 선언
        int num1;   // int 타입의 변수 name 을 선언 (int 타입?  integer 정수)
        int num2;

        // 변수의 초기화, 최초로 변수에 값을 대입
        num1 = 10; // 변수 num1 의 값으로 정수값 10을 대입(assign)
                    // = : 대입연산자 (assignment operator)
        num2 = 20;
        //num2 = 3.14;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        // num3 = 30;  // 선언안된 변수는 사용 불가.  에러메세지 cannot resolve

        // 변수값은 변경 가능.
        num1 = 123;
        num2 = 200;

        System.out.println("num1 + num2 = " + (num1 + num2));

        int num3;
//        System.out.println("num3 = " + num3);  // 초기화 되지 않은 변수는 사용 불가!

        // local variable (지역변수)
        // 지역 변수는 블럭 { ... } 안에서 선언된 변수
        // '선언된이후' 부터 '블럭의 마지막'까지만 사용 가능한 변수

        {
            int a;
            a = 100;
            System.out.println("a = " + a);
        } // 블럭이 종료되면 그 안에서 선언된 지역변수 a 는 소멸

        // System.out.println("a = " + a);


    } // end main
} // end class

















