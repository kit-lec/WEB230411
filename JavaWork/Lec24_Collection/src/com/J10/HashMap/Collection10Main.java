package com.J10.HashMap;

/* Map<K, V>, HashMap<K, V>
	 Collection<E>
	  |__ List<E>, Set<E>
	
	 List<E>
	  |__ ArrayList<E>, LinkedList<E>
	
	 Set<E>
	  |__ HashSet<E>, TreeSet<E>
	
	 Map<K, V>
	  |__ HashMap<K, V>, TreeMap<K, V>
	
	 Map: key-value 저장 방식의 자료 구조
	  1. key는 중복되지 않는 값만 허용
	  2. value는 같더라도 key 값이 다르면 저장 가능
	  3. 검색, 수정, 삭제를 할 때 key를 사용
*/


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("HashMap 클래스");

		// HashMap 인스턴스 생성
		// Key - Integer 타입
		// Value - String 타입
		Map<Integer, String> hmap = new HashMap<>();

		// 데이터 저장: put(key, value) 메소드 사용
		System.out.println("put = " + hmap.put(1, "최진형"));  // 데이터 추가
		System.out.println("put = " + hmap.put(2, "최민영"));
		System.out.println("put = " + hmap.put(3, "허소윤"));
		System.out.println("put = " + hmap.put(1, "권강현")); // 데이터 수정
		// 기존에 없던 key 값으로 put 하면 null 리턴하고
		// 같은 키 값으로 데이터를 put하게 되면, 기존 값이 수정(replace)되고 기존 값을 리턴함

		// 저장된 데이터 개수 확인 : size()
		System.out.println("hmap size(): " + hmap.size());

		System.out.println();

		// 데이터 읽기
		// get(key) 사용해서 value 읽기
		System.out.println(hmap.get(1));
		System.out.println(hmap.get(2));
		System.out.println(hmap.get(5));  // 없는 key 값에 대해선 null 리턴


		// 데이터 삭제
		// remove(key) : 삭제된 value 리턴
		// 없는 key 삭제하면 null 리턴
		System.out.println("삭제: " + hmap.remove(2));
		System.out.println("삭제: " + hmap.remove(2));

		// 방법1 HashMap에서 Iterator 사용
		// 1. HashMap의 keySet() 메소드를 사용해서
		// 저장된 키(key)값들만 이루어진 Set을 만듬.
		// 2. 1에서 만들어진 Set에 있는 iterator() 메소드를 사용해서
		// Iterator를 생성
		System.out.println();

		Set<Integer> keySet = hmap.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while(itr.hasNext()){
			int key = itr.next();
			System.out.println(key + " : " + hmap.get(key));
		}


		System.out.println();

		// 방법2 : Map.Entry 사용
		// entrySet() 은 Set<Entry<Integer, String>> 리턴함

		for(Map.Entry<Integer, String> entry : hmap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// for(var e : hmap){}  자바는 아직도 안되요 ㅠㅠ..

		for(var entry : hmap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// 방법3 : toString()
		System.out.println(hmap);

		System.out.println();

		// 도전과제
		// arr[] = {2, 4, 5, 4, 3, 3, 4}
		// 주어진 배열이 위와 같을때 다음과 같이 발생회수 나타내기
		// 2 : 1개
		// 3 : 2개
		// 4 : 3개
		// 5 : 1개

		System.out.println("HashMap 응용: 배열에서 발생빈도 구하기");
		int arr[] = {2, 4, 5, 4, 3, 3, 4};
		printFreq(arr);

		System.out.println("-".repeat(20));
		System.out.println("HashMap 초기화하는 방법들");
		{
			// Stream 사용 (Java 8이상)
			Map<String, String> map = Stream.of(new String[][]{
					{"Hello", "World"},  // {key, value}
					{"John", "Doe"},
			}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

			System.out.println(map);

			// key, value 가 서로 다른 타입이라면 Object[][] 로 초기화 가능
			Map<String, Integer> map2 = Stream.of(new Object[][]{
					{"data1", 1},  // {key, value}
					{"data2", 2},
			}).collect(Collectors.toMap(data -> (String)data[0], data -> (Integer)data[1]));
			System.out.println(map2);
		}

		// Java9 방식
		// Map.of( .. ) <= 최대 10개까지의 key, value 쌍 지정 가능
		{
			Map<String, String> map;
			map = Map.of();
			System.out.println(map);

			map = Map.of("key1", "value1");
			System.out.println(map);

			map = Map.of("key1", "value1", "key2", "value2", "key3", "value3");
			System.out.println(map);
		}

		// double-brace syntax 사용 (비추)
		{
			Map<String, String> map = new HashMap<>(){{
				put("key1", "value1");
				put("key2", "value2");
				put("key3", "value3");
			}};
			System.out.println(map);
		}


		System.out.println("\n프로그램 종료");
	} // end main()

	static void printFreq(int [] arr){
		// 발생빈도를 담을 Map<> 준비
		// key : 등장 숫자
		// value : 등장 횟수
		Map<Integer, Integer> hmap = new HashMap<>();

		for(int i = 0; i < arr.length; i++){
			Integer v = hmap.get(arr[i]);

			if(v == null){  // 기존에 해당 key값이 없었다면? => 즉! 첫등장
				hmap.put(arr[i], 1);   // 등장횟수 1
			}else{        // 기존에 key 값이 존재했다면 (즉, 이전에 1번이상 등장했다면)
				hmap.put(arr[i], v + 1);   // 기존 등장횟수 +1 증가
			}
		}

		// 결과 출력
		for(var entry : hmap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue() + "개");
		}

	}

} // end class















