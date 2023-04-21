package 배열1.형성평가04;

import java.util.Scanner;

/*
30 20 10 60 80 -1

 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];

        int n;
        for(n = 0; n < arr.length; n++){  // 배열의 length 만큼 입력
            arr[n] = sc.nextInt();
            if(arr[n] == -1) break;  // -1 입력되면 종료
        }

        int startIndex = (n - 3 >= 0) ? n - 3 : 0;
        for(int i = startIndex; i < n; i++){
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}











