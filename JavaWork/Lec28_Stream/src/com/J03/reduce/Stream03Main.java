package com.J03.reduce;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/* reduce() 연산
 * 
 *  전달된 스트림의 데이터를 2개를 소모하며 주어진 '연산' 수행
 *  주어진 연산은 결괏값 1개 리턴
 *  
 * 	reduce(초깃값, (전달된 스트림의 데이터) -> 연산기능)
 * 				  ↑
 * 				  직접 구현하든지,
 * 				  BinaryOperator 를 구현한 클래스
 * 
 *  기존의 주어진 연산 (count, sum 등..) 이 아닌 연산을 Stream 에 수행할때 필요
 *
 *  리턴값은 Optional 객체
 *
 * 데이터 연산 3대장
 *  	map : n개 -> n개
 *  	filter : n개 -> n`개 > (n' <= n)
 *  	reduce : n개 -> 1개
 */

public class Stream03Main {

	public static void main(String[] args) {
		System.out.println("reduce() 연산");
		
		int [] arr = {1, 2, 3, 4, 5};

		// 초깃값을 안 준 경우
		// TODO

		// 초깃값을 준 경우
		// TODO



		System.out.println();
		// 문자열에서 길이가 가장 긴 문자열을 뽑아내기 		
		String [] greetings = {"안녕하세요~~~", "Hello", "Good morning", "반갑습니다"};
		String result;
		
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


// 직접 구현도 가능
// TODO











