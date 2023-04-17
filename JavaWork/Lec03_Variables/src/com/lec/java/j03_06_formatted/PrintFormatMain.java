package com.lec.java.j03_06_formatted;
/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *
 *    printf("서식문자열", 값1, 값2....)
 *
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *
 *    String.format("서식문자열", 값1, 값2....)
 *
 *  ● format specifier (서식 지정자)
 *      %d  :  십진수 정수로 출력
 *      %f  :  실수 출력
 *      %s  :  문자열 출력
 *      %c  :  '문자하나' 출력
 *      %x  :  16진수 정수로 출력
 *      %%  :  % 출력
 */



public class PrintFormatMain {
    public static void main(String[] args) {

        double pi = Math.PI;
        System.out.println(pi);

        System.out.printf("원주율");
        System.out.printf("원주율\n");

        System.out.printf("원주율 %f\n", pi);  // 기본 실수 출력  (소숫점 6자리까지)
        System.out.printf("원주율 %.2f\n", pi);  // %.2f: 실수출력 (소숫점 2자리까지)
        System.out.printf("원주율 %.3f\n", pi);

        int age = 10;
        short grade = 3;

        System.out.printf("나이는 %d 살. 학년은 %d학년\n", age, grade);

        System.out.printf("%d, %x, %c\n", 65, 65, 65);

        // 출력폭 지정, 좌우 정렬
        System.out.printf("|%d|%d|%d|\n", 100, 200, 300);
        System.out.printf("|%5d|%5d|%5d|\n", 100, 200, 300);   // 폭5칸, 우측정렬
        System.out.printf("|%-5d|%-5d|%-5d|\n", 100, 200, 300);  // 좌측정렬
        System.out.printf("|%6.1f|\n", 182.345);  // 총6자리 출력, 소숫점이하 1자리

        System.out.println();

        // String.format()
        // 기본적으로 printf() 와 사용법은 동일함
        // 단, 화면에 출력하는게 아니라, 결과를 문자열(String) 으로 만들어서 리턴

        String.format("합격률은 %.1f%% 입니다", 57.86);
        String result = String.format("합격률은 %.1f%% 입니다", 57.86);
        System.out.println(result);

        // Text Block 으로 포맷팅
        String text = """
        {
            "title": %s,
            "author": %s,
            "id": %d
        }
                """.formatted("hi", "John", 2);

        System.out.println(text);

        System.out.println("\n프로그램 종료");
    } // end main()
} //end class













