package com.J01.stream생성;

import common.Customer;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  스트림 (Stream) : 집합자료의 연산을 위해 사용하는 객체
 *  - Java8 에서 등장
 *  - 람다 활용
 *  - InputStream / OutputStream 과는 전혀 다른 객체다. 헷갈리지 말자.
 *
 *  자료의 대상과 관계 없이 '동일한 연산'을 수행할 수 있는 기능 (자료의 추상화!)
 *
 *  주로 '배열', '컬렉션' 을 대상으로 '스트림 생성'하여 사용
 *  '배열', '컬렉션'에 '동일한 연산'으로 수행될수 있도록 '일관성' 있는 처리 가능
 *
 *  	: 동일한 연산임에도 불구하고 자료의 대상마다 다르다면, 불편+번거로움
 *  	: ex) 배열.length vs  컬렉션.size()
 *  		  배열[index] vs  list.get(index)
 *
 *  한번 생성하고 사용한 스트림은 재사용 불가
 *
 */

/**
 * 스트림 생성
 *   스트림을 생성할 때 스트림이 열리고 모든 연산이 행해지고 결과를 받으면 스트림이 닫힌다.
 *   스트림이 닫히면 해당 스트림을 재사용할 수 없기 때문에 스트림을 다시 생성해야한다.
 *   스트림의 생성은 stream(), of() 메서드를 이용해 컬렉션, 배열 등 다양한 곳에서 생성이 가능하다.
 *   stream()은 컬렉션 인터페이스의 기본 메서드로 정의되어 있다. Stream.of()를 통해 생성하는 것이 가능하다.
 */

public class Stream01Main {
	public static void main(String[] args) {
		
		
		int [] arr = {5, 2, 1, 4, 3};
		List<String> stringList = List.of("도라에몽", "포켓몬", "디지몬");
		List<Integer> intList = List.of(10, 20, 30, 40, 50);

		// Arrays.stream(int[]) => IntStream 생성
		IntStream is =Arrays.stream(arr);   // 배열 -> Stream 생성

		Stream<String> stringStream = stringList.stream();
		Stream<Integer> intStream = intList.stream();

		Map<String, Integer> person = Map.of("도라에몽", 200, "포켓몬", 12);
		Stream<Map.Entry<String, Integer>> entryStream = person.entrySet().stream();   // Map 의 EntrySet Stream 생성

		Set<Integer> integerSet = Set.of(10, 20, 30);
		Stream<Integer> stream = integerSet.stream();   // Set 의 Stream 생성

		// Stream.of 팩토리 메소드로 Stream 생성
		Stream<Integer> integerStream = Stream.of(200, 300, 400);
		Stream<Customer> customerStream = Stream.of(
				new Customer("도라에몽", 200)
				, new Customer("고질라", 40)
		);



		System.out.println("\n프로그램 종료");
	} // end main()
} // end class












