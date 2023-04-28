package com.lec.java.j16_02_다형성의이점;

/* 다형성의 유용성
	다형성에 의해서, 자식타입 객체가 부모타입으로 자동 형변환 가능!
	부모(조상)타입 만으로도 상속된 모~든 자손 타입들을 담을수 있다.
*/

import com.lec.java.j16_01_Polymorphism.*;

public class Polymorphism02Main {

	public static void main(String[] args) {
		System.out.println("다형성의 사용 (유용성)");

		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Car();
		Vehicle car3 = new HybridCar();

		Vehicle[] cars = new Vehicle[3];
		cars[0] = new Vehicle();
		cars[1] = new Car();
		cars[2] = new HybridCar();

		for(var car : cars){
			car.displayInfo();
		}

		// 다형성이 없었다면?  각 타입별로 변수들을 만들고 따로따로 사용해야 하는 왕불편.
		//		Vehicle car1 = new Vehicle();
		//		Car car2 = new Car();
		//		HybridCar car3 = new HybridCar();
		//		car1.displayInfo();
		//		car2.displayInfo();
		//		car3.displayInfo();

		System.out.println(car1);  // println(Object)  <-- Java 의 모든 객체를 받을수 있다! (다형성!)
		System.out.println(car2);
		System.out.println(car3);

		System.out.println();

		Vehicle car4 = new Vehicle();
		Car car5 = new Car();
		HybridCar car6 = new HybridCar();

		driveCar(car4);
		driveCar(car5);
		driveCar(car6);

		// instanceof 연산자
		// 용법: 변수/값 instanceof 클래스
		// 결과: true / false

		System.out.println(car1 instanceof Vehicle);
		System.out.println(car1 instanceof Car);
		System.out.println(car2 instanceof Vehicle);  // true  Car IS-A Vehicle
		System.out.println(car2 instanceof HybridCar);  // false

		System.out.println("\n 프로그램 종료");
	} // end main()

	public static void driveCar(Vehicle v){
		v.setSpeed(100);
		v.displayInfo();
	}

} // end class












































