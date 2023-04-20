package 반복제어문3.자가진단02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++){  // x n
            for(int j = 0; j <= i; j++)   // 바깥쪽 인덱스 변수 활용
                System.out.print("*");

            System.out.println();
        }

        System.out.println();

        for(int i = 0; i < n; i++){  // x n
            System.out.println("*".repeat(i + 1));
        }

        sc.close();
    }
}










