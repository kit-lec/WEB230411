package com.lec.java.j04_03_nextLine_next;

import java.util.Scanner;

public class Input03Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // > aaa bbb ccc
        System.out.print("여러 단어의 문장을 입력하세요 > ");
        String in = sc.nextLine();
        System.out.println("in: " + in);

        System.out.print("여러 단어의 문장을 입력하세요 > ");
        String in1 = sc.next();
        System.out.println("in1: " + in1);

        // 기존의 버퍼에 담겨 있는 내용들이 있다면?
        String in2 = sc.next();
        System.out.println("in2: " + in2);
        String in3 = sc.next();
        System.out.println("in3: " + in3);

        // primitive 타입을 여러개를 '한줄'로 입력받을수 있다.
        // > 100 3.14 300
        System.out.print("숫자 3개(int, double, short)를 입력받으세요 > ");
        int i1 = sc.nextInt();
        double d1 = sc.nextDouble();
        short s1 = sc.nextShort();

        System.out.printf("i1, d1, s1:  %d %f %d\n", i1, d1, s1);

        sc.close();
        System.out.println("\n프로그램 종료");
    }
}
