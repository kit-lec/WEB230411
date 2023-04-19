package com.lec.java.j06_01_if_else;

/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num = -10;

		if(num > 0){
			// if() 조건식이 true 일때 실행하는 코드
			System.out.println(num + " 은 양수입니다");
		} else {
			// if() 조건식이 false 일때 실행하는 코드
			System.out.println(num + " 은 양수가 아닙니다");
		}

		num = 123;
		if(num % 2 == 0){
			System.out.println(num + " 값은 짝수입니다");
		} else {
			System.out.println(num + " 값은 홀수입니다");
		}

		// 주어진 점수가 유효한 범위에 있는지 여부
		int score = -5;
		if(0 <= score && score <= 100){
			System.out.println("0 <= score <= 100");
		} else {
			System.out.println(score + "는 유효한 점수가 아닙니다");
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
