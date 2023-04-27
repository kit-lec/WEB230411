package com.lec.java.j15_04_상속과생성자;

public class Car extends Vehicle{

    int oil;

    public Car(){
        System.out.println("Car() 생성");
    }

    public Car(int oil) {
        super(77);   // 명시적으로 부모생성자 호출.
        this.oil = oil;
        System.out.println("Car(int) 생성: oil = " + oil);
    }

    public Car(int speed, int oil){
        super(speed);
        this.oil = oil;
        System.out.printf("Car(int, int) 생성 speed=%d, oil=%d\n", speed, oil);
    }
}








