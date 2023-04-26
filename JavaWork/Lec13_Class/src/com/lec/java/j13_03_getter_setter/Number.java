package com.lec.java.j13_03_getter_setter;

public class Number {

    private int num;  // 멤버변수

    // 디폴트 생성자
    public Number() {}

    // 매개변수 있는 생성
    public Number(int num){
        this.num = num;  // this : 자기자신(인스턴스)를 가리킴
    }

    // getter: 멤버 변수의 값을 리턴해 주는 메소드
    // setter: 멤버 변수의 값을 변경해 줄 수 있는 메소드

    public int getNum(){
        return this.num;
    }

    public void setNum(int num){
        this.num = num;
    }
}









