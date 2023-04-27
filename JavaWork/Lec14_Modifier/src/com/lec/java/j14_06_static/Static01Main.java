package com.lec.java.j14_06_static;

// 클래스에 선언된 멤버 변수/멤버 메소드는
// static 여부에 따라 아래와 같이 불려진다

// 인스턴스 변수: 
//   static 이 안붙은 변수
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 변수
// 인스턴스 메소드:
//   static 이 안 붙은 메소드
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 메소드

// 클래스 변수(static 변수):
//   클래스의 멤버 변수들 중에서,
//   인스턴스를 생성하지 않아도 사용할 수 있는 변수
// 클래스 메소드(static 메소드):
//   인스턴스를 생성하지 않아도 사용할 수 있는 메소드


public class Static01Main {

	int age = 70;
	static double avg = 3.14;

	public void test() {
		System.out.println("Hello Instance method");
	}


	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드 vs 클래스 변수/메소드");

		// static 은 절.대.로 non-static 을 사용 못함.
		//System.out.println(age);

		System.out.println(avg);

		//test();

		// 인스턴스 멤버(non-static) 은 인스턴스를 통해서 사용 가능
		Static01Main tc = new Static01Main();
		tc.test();
		System.out.println(tc.age);

	} // end main()

} // end class Static01Main











