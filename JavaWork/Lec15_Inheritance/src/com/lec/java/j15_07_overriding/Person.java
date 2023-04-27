package com.lec.java.j15_07_overriding;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void showInfo(){
        System.out.println("이름: " + name);
    }
}
