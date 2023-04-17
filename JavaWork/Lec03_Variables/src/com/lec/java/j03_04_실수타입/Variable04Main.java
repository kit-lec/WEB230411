package com.lec.java.j03_04_실수타입;

public class Variable04Main {
    public static void main(String[] args) {

        // 실수타입의 최소, 최댓값
        System.out.println("float: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
        System.out.println("double: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);

//        float: 1.4E-45 ~ 3.4028235E38
//        double: 4.9E-324 ~ 1.7976931348623157E308

        double number1 = 3.141592;
        //float number2 = 3.14;
        float number3 = 3.14f;   // float 리터럴

        float number4 = 1.23456789f;
        double number5 = 1.23456789;

        System.out.println("number4 = " + number4);
        System.out.println("number5 = " + number5);
        // float과 double은 저장할 수 있는 값의 크기만이 아니라
        // 소수점 이하 정밀도(precision)에서도 차이가 있다.

        // 실수 표기
        double number6 = 123;
        double number7 = 1.23e2;   // 지수표기법 (exponential notation)

        System.out.println(number6);
        System.out.println(number7);

        System.out.println(0.1 + 0.2);  // 실수의 연산은 오차가 발생할수 있다!
        System.out.println(0.3);

    } // end main()
} // end class






