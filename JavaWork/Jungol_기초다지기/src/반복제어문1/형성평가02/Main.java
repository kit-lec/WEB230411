package 반복제어문1.형성평가02;

import java.util.Scanner;

/*
9 7 10 5 33 65 0

 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i ;
        int odd = 0;   // 홀수의 개수
        int even = 0;  // 짝수의 개수


        for(;;){
            i = sc.nextInt();
            if(i == 0) break;  // 무한루프 종료조건

            if(i % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("odd : " + odd);
        System.out.println("even : " + even);

        sc.close();
    } // end main
} // enc class












