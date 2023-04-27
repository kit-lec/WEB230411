package com.lec.java.j14_08_singleton;

public class Test {

    private int num;

    // singleton 디자인 패턴
    private Test(){
        num = 100;
    }

    private static Test instance = null;  // 생성된 instance 를 참조

    public static Test getInstance(){
        if(instance == null){  // 기존에 생성된 instance 가 없었다면
            instance = new Test();  // 생성!
        }
        return instance;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}











