package com.lec.spring.di03;

import com.lec.spring.beans.Score;
import com.lec.spring.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiMain03 implements CommandLineRunner {

    @Autowired   // 자동주입, field injection.  필드 타입과 같은 bean 이 컨테이너 안에 있으면 자동 주입 받는다.
    Score scoreA;

    @Autowired
    Student stuA;

    @Autowired
    ApplicationContext ctx;  // 스프링 컨테이너

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
        System.out.println(scoreA);
        System.out.println(stuA);

        System.out.println(scoreA == stuA.getScore());  // 둘은 같은 인스턴스 (동일 빈 객체!)

        // 컨테이너에 생성된 bean 은 'bean 의 이름' 으로 접근할수 있다
        System.out.println(ctx.getBean("score1"));
        System.out.println(ctx.getBean("stu1"));

    }
} // end Main
