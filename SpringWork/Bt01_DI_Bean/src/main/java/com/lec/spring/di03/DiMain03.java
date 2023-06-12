package com.lec.spring.di03;

import com.lec.spring.beans.Score;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiMain03 implements CommandLineRunner {

    Score scoreA;

    public DiMain03() {
        System.out.println(getClass().getName() + "() 생성");
    }

    public static void main(String[] args) {
        System.out.println("Main 시작");
        SpringApplication.run(DiMain03.class, args);
        System.out.println("Main 종료");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(scoreA);  //??
    }
} // end Main
