package com.J03.reduce;

import common.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/* reduce() 연산  [최종연산]
 * 
 *  전달된 스트림의 데이터를 reduce 연산을 적용하여 소모하며 최종적으로
 *  결괏값 1개 리턴
 * 
 *   입력  =>   출력
 *    n개   =>  1개
 *
 *  reduce(Identity, accumulator), reduce(accumulator)
 * 	reduce(초깃값, (전달된 스트림의 데이터) -> 연산기능)
 * 				  ↑
 * 				  직접 구현하든지,
 * 				  BinaryOperator 를 구현한 클래스
 * 
 *  기존의 주어진 연산 (count, sum 등..) 이 아닌 연산을 Stream 에 수행할때 필요
 *
 *  리턴값은 
 *      초깃값이 없으면 Optional 리턴
 *      초깃값이 있으면 초깃값 타입 리턴
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
		System.out.println(Arrays.stream(arr)
				.reduce((a, b) -> a + b));  // reduce(accumulator)

		System.out.println(Arrays.stream(arr)
				.reduce((a, b) -> a + b)
				.orElse(0));

		// 1, 2, 3, 4, 5
		// ↘ ↓
		//    3, 3, 4, 5
		//    ↘ ↓
		//       6, 4, 5
		//       ↘ ↓
		//         10, 5
		//          ↘ ↓
		//            15

		// 초깃값을 준 경우
		System.out.println(Arrays.stream(arr)
				.reduce(100, (a, b) -> a + b)
		);

		// 100, 1, 2, 3, 4, 5
		//    101
		//      103
		//         106
		//            110
		//               115

		System.out.println();
		// 문자열에서 길이가 가장 긴 문자열을 뽑아내기
		String [] greetings = {"안녕하세요~~~", "Hello", "Good morning", "반갑습니다"};
		String result;

		result = Arrays.stream(greetings)
				.reduce("", (s1, s2) -> (s1.length() >= s2.length()) ? s1 : s2);
		System.out.println("result = " + result);

		// 도전!
		{
			List<Customer> personList = List.of(
					new Customer("zayson", 28),
					new Customer("chaeyoung", 26),
					new Customer("maeng", 30)
			);
			
			// 나이가 28이하인 사람들의 나이의 합
			int ageSum = personList.stream()
					.mapToInt(Customer::getAge)
					.filter(age -> age <= 28)
					.reduce(0, (a, b) -> a + b);
			System.out.println(ageSum);


		}




		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


// 직접 구현도 가능
// TODO











