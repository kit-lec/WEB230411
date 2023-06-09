package com.lec.java.j23_07_AnonymousClass;

/* Anonymous inner class(익명 내부 클래스):
 * 	이름이 없는 local inner class
 * 	이름이 없기 때문에 생성자로 만들 수가 없습니다.
 * 	클래스의 정의와 동시에 인스턴스를 생성합니다.
 * 
 * 익명 내부 클래스:
 * 	인스턴스 생성과 동시에 이름없는 클래스가 정의됨.
 * 
 * 	new 인터페이스() { 익명 클래스 내부 작성 };
 * 	new 부모클래스() { 익명 클래스 내부 작성 };
 * 
 * 익명 내부 클래스 (Anonymous Inner class) 는
 * 인터페이스 뿐 아니라, 일반 클래스, 추상클래스 등도 가능하다.
 *  상속 받은 (이름없는) 클래스의 인스턴스를 생성.
 *  - 멤버 변수/ 메소드 선언
 *  - 메소드 오버라이딩 
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");

		Person p = new Person("Susan");
		MyReadable r = p.createInstance(20);
		r.readInfo();  // 주인공은 readInfo() 메소드


		//------------------------------------------------
		System.out.println();

		MyReadable r2 = new MyReadable() {

			int a = 10;   // 익명클래스의 멤버변수

			@Override
			public void readInfo() {
				System.out.println("readInfo()");
				System.out.println("a = " + a);
			}
		};
		r2.readInfo();

		System.out.println(r2);

		int n = 12;  // effective final 사용 가능

		new MyReadable(){

			@Override
			public void readInfo() {
				System.out.println("n * 2 = " + n * 2);
			}
		}.readInfo();


		//------------------------------------------------
		System.out.println();
		MyAbstract abs = new MyAbstract() {
			@Override
			int methodA(int a) {
				return a * 3;
			}
		};

		System.out.println(abs.methodA(10));
		System.out.println(abs.methodA(20));

		abs = new MyAbstract() {
			@Override
			int methodA(int a) {
				return a + 10;
			}
		};
		System.out.println(abs.methodA(100));

		System.out.println("-".repeat(20));

		System.out.println(new MyClass().methodA(15));

		int result = new MyClass(){
			@Override
			int methodA(int c) {
				return (int)Math.pow(c , 2);
			}
		}.methodA(15);
		System.out.println(result);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

//익명 내부 클래스 (Anonymous Inner class) 는
//인터페이스 뿐 아니라, 일반 클래스, 추상클래스 등도 가능하다.
//상속 받은 (이름없는) 클래스의 인스턴스를 생성.
//	- 멤버 변수/ 메소드 선언
//	- 메소드 오버라이딩 

abstract class MyAbstract{

	int n = 10;
	int d = 2;

	abstract int methodA(int a);

} // end class

class MyClass {

	int a = 10;
	int b = 20;

	int methodA(int c) {return a + b + c;}

} // end class












