package com.lec.java.j15_07_overriding;

// final class 는 더 이상 상속 불가
//public final class Person {
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // final 메소드는 더이상 오버라이딩 안됨.
    //protected final void showInfo(){
    protected void showInfo(){
        System.out.println("이름: " + name);
    }
}










