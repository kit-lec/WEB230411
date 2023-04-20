package 반복제어문2.형성평가04;

/*
3
99 65 30

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int total = 0;  // 누적 합계
        
        for(int i = 0; i < n; i++){  // n번 순환
            total += sc.nextInt();
        }

        // 평균 계산
        double avg = (double)total / n;
        System.out.printf("%.2f", avg);

        sc.close();
    }
}










