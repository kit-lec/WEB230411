package com.lec.java.j15_07_overriding;

public class BusinessPerson extends Person{

    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // 메소드 오버라이딩
    // 부모클래스의 메소드를 자식이 재정의.
    @Override
    //private void showInfo() {  // 에러
    public void showInfo() {  // OK
        super.showInfo();
        System.out.println("회사: " + company);
    }

    // 메소드 오버로딩
    public void showInfo(int id){

    }
}
