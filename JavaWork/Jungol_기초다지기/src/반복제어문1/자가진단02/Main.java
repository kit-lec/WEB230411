package 반복제어문1.자가진단02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;  // 누적 합산할 변수
        int i = 1;
        while(i <= n){
            sum += i;
            i++;
        } // end while


        System.out.println(sum);

        sc.close();
    }
}









