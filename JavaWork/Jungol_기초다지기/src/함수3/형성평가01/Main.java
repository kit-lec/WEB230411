package 함수3.형성평가01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        printNum(n);

        sc.close();
    } // end main()

    public static void printNum(int n){
        if(n < 1) return;
        printNum(n / 2);
        System.out.print(n + " ");
    }
}
