package com.J04.BigDecimal;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 *     
 * 3. Wrapper 는 null 값 표현 가능
 */
public class Wrapper04Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");

		Object[] obj = new Object[5];

		obj[0] = "Hello";
		obj[1] = new int[]{10, 20, 30};
		obj[2] = new Wrapper04Main();
		obj[3] = 123;  //???
		obj[4] = 3.14; // ???
		// ↑ auto-boxing => Wrapper => 클래스다형성 => Object

		for(var e : obj){
			System.out.println(e);
		}

		//int num = obj[3];  // 에러
		int num = (Integer)obj[3];
		// ↑ 실제 담고 있는게 Integer 다 하더라도,
		//  원소타입이 Object 이기 때문에  일단 Wrapper 로 형변환 하여 auto-unboxing 이 발생하게 해야 한다

		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO

} // end class

// TODO