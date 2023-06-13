package com.lec.spring.di05;


import com.lec.spring.beans.MessageBean;
import com.lec.spring.beans.Score;
import com.lec.spring.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config05 {

    public Config05() {
        System.out.println("Config05() 생성");
    }

    @Bean
    public Score scoreA(){
        return new Score(100, 80, 75, "좋아요");
    }


    @Bean(name = "Park")
    public Student Stu1(){
        return new Student("박주찬", 19, scoreA());
    }

    @Bean
    public Student stu2(){
        return new Student("홍길동", 34, scoreA());
    }

    @Bean
    @Primary   // MessageBean 타입 빈 객체가 여럿 있는경우 @Primary 가 주입됨.
    public MessageBean msg1(){return new MessageEng();}

    @Bean
    public MessageBean msg2(){return new MessageKor();}
}

















