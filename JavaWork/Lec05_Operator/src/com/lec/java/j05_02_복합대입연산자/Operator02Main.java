package com.lec.java.j05_02_복합대입연산자;

/* 복합 대입 연산자 compound assignment operators
 * 
 * 		+=, -=, *=, /=, %=, ...
 */
public class Operator02Main {

	public static void main(String[] args) {
		System.out.println("연산자(Operator) 2 - 복합 대입 연산자 compound assignment operators");
		System.out.println("+=, -=, *=, /=, %=, ...");

		int num1 = 10;
		System.out.println("num1 = " + num1);
		// 기존의 변수값에 +1 증가
		num1 = num1 + 1;
		System.out.println("num1 = " + num1);
		num1 += 1;
		System.out.println("num1 = " + num1);

		int num2 = 100;
		num2 += 20;   // num2 = num2 + 20 과 동일
		System.out.println("num2 = " + num2);

		double num4 = 3.14;
		num4 *= 2;
		System.out.println("num4 = " + num4);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


/**
 * Debug (디버깅)
 * 		: 프로그램의 '논리적 오류' 를 찾아내기 위한 작업
 * 		: "프로그램의 실력은 곧 디버깅 실력이다!"
 *
 * 	step1 : breakpoint 설정  (CTRL + F8)  (목록: CTRL+SHIFT+F8)
 * 	step2 : debug 시작       (SHIFT + F9)
 * 	        breakpoint 를 만나면 프로그램 실행이 일시 중단된다 -> step3 로
 * 	step3 :
 * 		 step over : 한 단계씩 명령 실행 (F8)
 * 		 resume : 다음 breakpoint 까지 진행 (F9)
 *
 *      확인해야 하는 것들
 * 		1) 프로그램의 흐름
 * 		2) 변수값의 변화
 * 		3) 호출관계 흐름
 *
 * 	step4 : debug 종료 (terminate)  (CTRL+F2)
 *
 */








