package com.lec.java.j14_07_static;

//클래스 변수 / 메소드 특징 (static)
//1. 메모리의 '메소드 영역'에 클래스가 로드 될때(프로그램 시작될때) '한번만' 생긴다
//2. 인스턴스가 생성되지 않아도 사용할 수 있다.
//		- 클래스이름.static변수,  클래스이름.static메소드()  <-- 요렇게 사용한다
//3. 모든 인스턴스는 하나의 static 변수/메소드를 '공유'한다.


public class Static02Main {

	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드");

		Test.show2();
		Test.sNum = 123;
		Test.show2();

		//Test.num = 10;

		Test t = new Test();
		t.num = 100;
		t.show();

		Test t2 = new Test();
		t2.show();

		Test.sNum = 987;
		t.show();
		t2.show();

		t2.sNum = 340;  // 가능하긴 하나... static 은 static 방법으로 사용하자!!
		t.show();



		
	} // end main()

} // end class Static02Main







