package com.lec.java.j14_03_access;



// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

//import com.lec.java.j14_04_access.TestDefault2;
import com.lec.java.j14_04_access.TestPublic2;

//import com.lec.java.j14_04_access.TestPublic;

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		
		TestPublic t1 = new TestPublic();

		MyDefault t2 = new MyDefault();

		TestPublic2 t3 = new TestPublic2();

		// 4. 다른 패키지에 있는 (default) 클래스
		// -> 인스턴스 생성 불가능
		//  애시당초 import 에서 에러다
		// TestDefault2 t4;

		// 14_4 의 TestPublic 을 사용하려면?
		// 다른패키지의 같은 이름의 클래스 사용하려면?
		com.lec.java.j14_04_access.TestPublic t4
				= new com.lec.java.j14_04_access.TestPublic();

	} // end main()

} // end class Access05Main

class A{}
class B{}

//public class C{}








