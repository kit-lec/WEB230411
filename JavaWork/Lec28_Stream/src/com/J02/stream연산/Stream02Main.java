package com.J02.stream연산;

import common.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *   스트림 연산
 *  스트림 연산은 기존자료를 변경하지 않음 (즉 배열에서 생성한 스트림이 원본 배열을 직접 건드리진 않음)
 *  스트림 연산은 '중간연산'과 '최종연산'으로 구분됨
 *
 *  	'중간연산'
 *  		어떤 조건으로 자료를 filtering 한다든가, 어떤 조건에 맞는 자료를 꺼내온다든다
 *  		중간연산은 체이닝 된다.
 *
 *  		map(), filter(), sorted(), distinct(),
 *  		limit(), skip(), peek(), boxed()
 *  		...
 *
 *          중간연산은 데이터를 다시 Stream 타입으로 리턴하기 때문에 이후 체이닝 가능.
 *
 *
 *  	'최종연산 (터미널 연산)'
 *  		그 결과를 출력한다든가, 합 혹은 평균을 구하는 등의 연산 -> '결과'가 나온다
 *  		최종연산은 자료를 '소모' 하면서 연산을 수행
 *  		그래서, 맨 마지막에 등장. 최종연산후에 스트림은 더이상 다른연산 적용 불가.
 *  		최종연산이 적용(수행)되어야 모든 그 앞의 중간연산이 적용되는 '지연연산'이 발생
 *
 *
 *  		min(), max(), count(), sum(), average()
 *  		reduce(a, b)
 *  		anyMatch(), allMatch(), noneMatch()
 *  	    collecting()
 *  	    forEach()
 *  		...
 */

public class Stream02Main {
	public static void main(String[] args) {
		System.out.println("Stream01");

		List<String> sList = Arrays.asList("John", "Susan", "Tom", "Michael");
		Customer[] arrCustomer = {
				new Customer("Susan", 22),
				new Customer("John", 32),
				new Customer("Tom", 55),
				new Customer("john", 43),
		};

		List<Customer> customerList = Arrays.asList(arrCustomer);

		// forEach(Consumer<>)
		customerList.stream()
				.forEach(s -> System.out.println(s));


		// Filter
//		filter()는 Predicate 함수형 인터페이스를 파라미터로 받고 이에 해당하는 요소를 스트림에서 뽑는다.
//		filter()의 파라미터로 boolean값을 반환하는 람다식을 파라미터로 전달한다.
		// 입력 -> 출력
		//  n   -> <= n

		// 나이가 28살 이하인 사람만 출력
		System.out.println("\nFilter");
		customerList.stream()
				.filter(c -> c.getAge() <= 28)
				.forEach(System.out::println);

		// Map(Function<T,U>)
		// Stream 의 요소를 '변환'한 새로운 Stream 리턴
		// 입력 => 출력
		//  n   => n

		System.out.println("\nMap");
		customerList.stream()  // Stream 생성
				//.map(c -> c.getName())  // 중간연산 Stream<String> 추출
				.map(Customer::getName)
				.forEach(System.out::println); // 최종연산


		// sorted()
		//  Stream 을 정렬한 Stream 을 리턴
		//  매개변수 Comparator<>  <- 대소 비교

		System.out.println("\nsorted()");
		sList.stream().forEach(System.out::println);
		System.out.println();
		sList.stream().sorted().forEach(System.out::println);

		System.out.println();
		customerList.stream()
				.sorted(Comparator.comparing(Customer::getName))
				.forEach(System.out::println);

		System.out.println();
		customerList.stream()
				.sorted(Comparator.comparing(Customer::getAge))  // 나이 오름차순
				.forEach(System.out::println);

		System.out.println();
		customerList.stream()
				.sorted(Comparator.comparing(Customer::getAge).reversed())  // 나이 내림정렬
				.forEach(System.out::println);

		// distinct
		//  Stream 에서 중복된 요소 제거한 Stream 리턴
		// primitive type 의 경우  == 으로 '같은지 여부' 판단
		// object type 의 경우 .equals() 로 '같은지 여부' 판단
		int[] intArr = {9, 1, 1, 0, 2, 2, 2, 5, 9, 2, 0};
		System.out.println();
		Arrays.stream(intArr).distinct().forEach(System.out::println);

		System.out.println();
		customerList.stream().distinct().forEach(System.out::println);

		// limit()
		//   Stream 의 가장 앞 쇼소부터 지정한 개수만큼을 Stream 으로 리턴
		System.out.println("\nlimit()");
		Arrays.stream(intArr).limit(5).forEach(System.out::println);

		// skip()
		//   Stream 의 앞요소부터 지정한 개수만큼을 제외한 Stream 리턴
		System.out.println("\nskip()");
		Arrays.stream(intArr)
				.skip(3)
				.limit(6)
				.forEach(System.out::println);

		// peek()
		//    현재 진행중인 Stream 에 영향을 주지 않으면서 현재까지 연산된 요소들을 출력하는등의 동작 수행


		List<String> nameList = new ArrayList<>();

		customerList.stream()
				.limit(2)
				.map(Customer::getName)
				.peek(name -> nameList.add(name))
				.filter(name -> name.startsWith("J"))   // "J" 로 시작하는 사람만
				.forEach(System.out::println);

		System.out.println("nameList : " + nameList);

		System.out.println("-".repeat(20));
		System.out.println("[최종연산(터미널 연산)]");

		int result = customerList.stream()
				.mapToInt(Customer::getAge)
				.sum();
		System.out.println("sum() = " + result);

		result = customerList.stream()
				.mapToInt(Customer::getAge)
				.min().getAsInt();   // min() 은 OptionalInt 리턴
		System.out.println("min() = " + result);

		var result2 = customerList.stream()
				.mapToInt(Customer::getAge)
				.average().getAsDouble();   // average() 은 OptionalDouble 리턴
		System.out.println("average() = " + result2);

		var result3 = customerList.stream().map(Customer::getAge).filter(age -> age >= 30).count();
		System.out.println("count() = " + result3);

		// TODO


		System.out.println("\n프로그램 종료");
	} // end main
} // end class





