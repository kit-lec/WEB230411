package com.lec.java.j24_04_기본함수형인터페이스들;

/*  자바 에서 제공하는 기본적인 함수형 인터페이스들
    1. Runnable
       기존부터 존재하던 인터페이스
       매개변수 없슴.  리턴타입 void.

    2. Supplier<T>
       매개변수 없슴.  리턴타입 (T타입).

    3. Consumer<T>
       매개변수 있슴(T타입).  리턴타입 void.

    4. Function<T, R>
       하나의 매개변수 (T타입).  리턴타입 (R타입).

    5. Predicate<T>
       하나의 매개변수 (T타입). 리턴타입 boolean

    6. UnaryOperator<T>
      하나의 매개변수(T타입).  리턴타입 (매개변수와 동일한 T타입)

    7. BinaryOperator<T>
      동일타입 매개변수2개 (T타입).  리턴타입 (매개변수와 동일한 T타입)

    8. BiPredicate<T, U>
      서로다른타입 매개변수2개 (T, U타입).  Boolean 리턴타입

    9. BiConsumer<T, U>
       서로다른타입 매개변수2개 (T, U타입).  리턴타입 void

    10. BiFunction<T, U, R>
       서로다른타입 매개변수2개 (T, U타입).  리턴타입 R타입
       
    11. Comparator<T>
        자바의 전통적인 인터페이스중 하나 객체의 우선순위 비교.
        동일타입 매개변수2개 (T타입).  리턴타입 정수
 */


import java.util.function.*;

public class Lambda04Main {
    public static void main(String[] args) {

        // Runnable
        {
            Runnable r = () -> System.out.println("hello functional");
            r.run();
        }

        //  Supplier<T>
        {
            Supplier<String> s = () -> "hello supplier";
            System.out.println(s.get());
        }

        // Consumer<T>
        {
            Consumer<String> c = str -> System.out.println(str);
            c.accept("hello consumer");
        }

        // Function<T, R>
        {
            Function<String, Integer> f = str -> Integer.parseInt(str);
            System.out.println(f.apply("2023"));
        }

        //  Predicate<T>
        {
            Predicate<String> p = str -> str.isEmpty();
            System.out.println(p.test("hello"));
            System.out.println(p.test(""));
        }

        // UnaryOperator<T>
        {
            UnaryOperator<String> u = str -> str + " operator";
            System.out.println(u.apply("hello unary"));
        }

        // BinaryOperator<T>
        {
            // TODO
        }

        // BiPredicate<T, U>
        {
            // TODO
        }

        //  BiConsumer<T, U>
        {
            // TODO
        }

        // BiFunction<T, U, R>
        {
            // TODO
        }

        // Comparator<T>
        {
            // TODO
        }

    } // end main
    
} // end class
