package 반복제어문1.형성평가03;

import java.util.Scanner;

/*
55 100 48 36 0 101
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int sum = 0, cnt = 0;   // '합계' 와 '개수'

        while(true){
            n = sc.nextInt();
            if(n < 0 || 100 < n) break;   // 무한루프 종료조건

            // 누적 합산
            sum += n;
            // 개수 카운트
            cnt++;
        }

        // 결과 출력
        System.out.println("sum : " + sum);
        System.out.printf("avg : %.1f", (double)sum / cnt);

        sc.close();
    }
}
















