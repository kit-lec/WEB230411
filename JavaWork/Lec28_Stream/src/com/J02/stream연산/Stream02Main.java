package com.J02.stream연산;

import common.Customer;

import java.util.*;
import java.util.stream.*;

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

//		System.out.println();
//		customerList.stream().distinct().forEach(System.out::println);

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

		//-------------------------------------------------------------
		// boxed()는
		// primitive 타입 스트림을 => 레퍼런스 타입 스트림으로 boxing 해준다. (boxed 스트림)
		System.out.println("-".repeat(30) +"\n▶ boxed()");
		{
			IntStream intStream = Arrays.stream(intArr);
			Stream<Integer> boxedStream = intStream.boxed();
		}

		//-------------------------------------------------------------
		// mapToInt(), mapToDouble(), mapToLong()
		// boxed 타입 스트림 -> primitive 타입 스트림을 변환
		System.out.println("-".repeat(30) +"\n▶ mapToInt(), mapToDouble(), mapToLong()");
		{
			Stream<Double> boxedStream;

			boxedStream = Stream.of(10., 20., 30.);
			IntStream intStream = boxedStream.mapToInt(x -> x.intValue());

			boxedStream = Stream.of(10., 20., 30.);
			DoubleStream doubleStream = boxedStream.mapToDouble(x -> x.doubleValue());

			boxedStream = Stream.of(10., 20., 30.);
			LongStream longStream = boxedStream.mapToLong(x -> x.longValue());
		}


		//----------------------------------------------------------------
		System.out.println("-".repeat(20));
		System.out.println("[최종연산(터미널 연산)]");

		//---------------------------------------------------------------
		// sum(), count(), average()    [최종연산]
		//
		//  sum()
		//    primitive stream 에서만 사용 가능.
		//    리턴값: 해당 타입
		//  count()
		//    primitive, boxed 스트림 양쪽에서 사용 가능
		//    리턴값: long
		// average()
		//    primitive stream 에서만 사용 가능.
		//    리턴값 Optional:  Optional<T>, OptionalInt, OptionalDouble ..
		System.out.println("-".repeat(30) +"\n▶ sum(), count(), average()");


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

		//---------------------------------------------------------------
		// min(), max()   [최종연산]
		//
		//  min(), max() 는 primitive, boxed 스트림 양쪽에서 사용 가능
		//    primitive 타입의 경우 max()에 파라미터가 없고, getAsInt()를 이용해 반환 받을 수 있다.
		//    reference 타입인 경우 max()에 Comparator가 파라미터로 들어간다.
		// Optional 리턴:  Optional<T>, OptionalInt, OptionalDouble ..
		System.out.println("-".repeat(30) +"\n▶ min(), max()");
		{
			// boxed stream
			Integer maxAge2 = customerList.stream()    // Stream<Customer>
					.map(Customer::getAge)   // Stream<Integer>
					.max(Integer::compare)   // Optional<Integer>
					.get();

			System.out.println("maxAge2 = " + maxAge2);

			// 최소 나이 출력?
			// primitive stream
			int minAge1 = customerList.stream()
					.mapToInt(Customer::getAge)
					.min()
					.getAsInt();

			// boxed stream
			Integer minAge2 = customerList.stream()
					.map(Customer::getAge)
					.min(Integer::compare)
					.get();

			System.out.println("minAge1 = " + minAge1);
			System.out.println("minAge2 = " + minAge2);
		}

		//---------------------------------------------------------------
		// Match  [최종연산]
		// 스트림 연산 결과에 대해서 조건을 검사해 true/false로 리턴한다.
		//   매개변수: Predicate<T>
		//   anyMatch() : 조건을 충족하는 요소가 하나라도 있는 경우 true
		//   allMatch() : 모든 요소가 조건을 충족하는 경우 true
		//   noneMatch() : 모든 요소가 조건을 충족하지 않는경우 true
		System.out.println("-".repeat(30) +"\n▶ **Match(Predicate<T>)");
		{
			System.out.println("customerList: " + customerList);

			// 이름에 "o" 가 들어가 있나요?
			boolean anyMatch1 = customerList.stream()
					.anyMatch(person -> person.getName().contains("o"));
			System.out.println("anyMatch1 = " + anyMatch1);

			boolean allMatch1 = customerList.stream()
					.allMatch(person -> person.getName().contains("o"));
			System.out.println("allMatch1 = " + allMatch1);

			// 나이가 모두 10살 이상인가요?
			boolean allMatch2 = customerList.stream()
					.allMatch(person -> person.getAge() >= 10);
			System.out.println("allMatch2 = " + allMatch2);

			// 이름이 모두 10글자 이상이 아닙니까?
			boolean noneMatch = customerList.stream()
					.noneMatch(p -> p.getName().length() >= 10);
			System.out.println("noneMatch = " + noneMatch);

		}

		//---------------------------------------------------------------
		// Collecting   [최종연산]
		//
		// collect(Collector<T, A, R>)
		//    스트림 중간 연산을 결과를 Collector 형태의 파라미터를 받아
		//    다양한 형태로 결과를 만들어준다.
		//
		// Collector<T, A, R>
		//     T : 입력 요소 타입
		//     A : reduction 연산의 누적값 타입
		//     R : reduction 최종 결과 타입
		//
		// Collectors.toList(), Collectors.toMap(), Collectors.toSet()
		//     각각 연산의 결과를 List, Map, Set 으로 변환해 결과를 만든다.
//
		System.out.println("-".repeat(30) +"\n▶ collect(Collector<T, A, R>)");
		{
			List<Customer> personList = List.of(
					new Customer("zayson", 28),
					new Customer("chaeyoung", 26),
					new Customer("maeng", 30),
					new Customer("joon", 28)
			);
			// 1) 이름만 List 로 뽑기
			List<String> nameList2 = personList.stream()
					.map(Customer::getName)
					.collect(Collectors.toList());
			System.out.println("nameList2 = " + nameList2);

			// 나이대를 뽑기 Set 으로 뽑기
			Set<Integer> ageSet = personList.stream()
					.map(x -> x.getAge() / 10 * 10)
					.collect(Collectors.toSet());
			System.out.println("ageSEt = " + ageSet);

			// 이름:나이  의 Map 으로 뽑기
			Map<String, Integer> personMapByName = personList.stream()
					.collect(Collectors.toMap(Customer::getName, Customer::getAge));
			System.out.println("personMapByName = " + personMapByName);

			// 나이:이름 의 Map 으로 뽑기
			// key 가 중복인 경우 예외 발생
//			Map<Integer, String> personMapByAge = personList.stream()
//					.collect(Collectors.toMap(Customer::getAge, Customer::getName));

			// 위 경우 BinaryOperator 이용해 덮어쓰기
			Map<Integer, String> personMapByAge = personList.stream()
					.collect(Collectors.toMap(Customer::getAge, Customer::getName, (oldValue, newValue) -> newValue));
			System.out.println("personMapByAge = " + personMapByAge);

			// Collectors.joining()은 연산한 결과가 String 타입일 때 여러 결과 문자열을 하나로 합쳐주는 역할을 한다.
			//    파라미터가 없는 경우 : 문자열을 그대로 이어붙힌다.
			//    파라미터가 1개인 경우 (delimiter) : 각 문자열 사이에 구분자를 넣을 수 있다.
			//    파라미터가 3개인 경우 (delimiter, prefix, suffix) : 각 문자열 사이에 구분자를 넣고, 하나로 합쳐진 문자열 앞뒤에 문자열을 추가해 붙힌다.

			String name1 = personList.stream().map(Customer::getName).collect(Collectors.joining());
			System.out.println("name1 = " + name1);

			String name2 = personList.stream().map(Customer::getName).collect(Collectors.joining("/"));
			System.out.println("name2 = " + name2);

			String name3 = personList.stream().map(Customer::getName).collect(Collectors.joining("/", "[", "]"));
			System.out.println("name3 = " + name3);

			// Collectors.summarizingInt(), Collectors.summingInt(), Collectors.averagingInt()
			//   통계를 내어 최대값, 최소값, 개수, 합계, 평균을 구하거나
			//   직접 합계나 평균을 구하는 것이 가능하다.
			// Int, Double, Long 모두 지원

			Integer sum1 = personList.stream().collect(Collectors.summingInt(Customer::getAge));
			System.out.println("sum1 = " + sum1);

			long sum2 = personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getSum();
			System.out.println("sum2 = " + sum2);

			System.out.println(personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getCount());
			System.out.println(personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getMax());
			System.out.println(personList.stream().collect(Collectors.summarizingInt(Customer::getAge)).getMin());

			// Collectors.groupingBy()는 파라미터로 그룹핑 할 기준을 정해주면 해당 기준으로 데이터를 그룹핑한다.
			// 데이터 그룹핑 (나이기준으로 데이터 그룹핑)
			Map<Integer, List<Customer>> collectByAge = personList.stream()
					.collect(Collectors.groupingBy(Customer::getAge));
			System.out.println("collectByAge = " + collectByAge);

			// Collectors.partitioningBy()는 파라미터로 Predicate를 받는다.
			// 따라서, 해당 조건을 통해 나온 True/False를 기준으로 결과 데이터를 두 파티션으로 나눈다.

			// 데이터 두 부분으로 구분
			// 이름이 5글자보다 많은 경우 구분
			Map<Boolean, List<Customer>>  nameCollect = personList.stream().collect(Collectors.partitioningBy(person -> person.getName().length() > 5));
			System.out.println("nameCollect = " + nameCollect);


		}


		System.out.println("\n프로그램 종료");
	} // end main
} // end class





