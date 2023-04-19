package com.lec.java.j07_04_switch와enum;

public class Switch04Main {

	// enum 타입 정의하는 방법: (enumeration)
	// enum 이름 {}
	// enum 타입 정의 메소드 안에서는 할 수 없다.

	enum Days {SUN, MON, TUE, WED, THU, FRI, SAT}  // Days enum 타입 정의

	public static void main(String[] args) {
		System.out.println("enum 타입을 switch에서 사용하기");

		Days day1 = Days.THU;
		System.out.println(day1);
		Days day2 = Days.MON;
		System.out.println(day1 == day2);   // == 연산 가능

		Subjects subj1 = Subjects.KOREAN;
		Subjects subj2 = Subjects.MATH;

		switch(subj1){  // enum 타입 사용
			case KOREAN:
				System.out.println("국어");
				break;
			case MATH:
				System.out.println("수학");
				break;
			case ENGLISH:
				System.out.println("영어");
				break;
		}


		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










