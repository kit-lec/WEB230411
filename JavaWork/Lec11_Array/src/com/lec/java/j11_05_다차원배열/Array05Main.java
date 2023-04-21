package com.lec.java.j11_05_다차원배열;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 *  1차원 배열 (one-dimensional array) 이라고 함
 *   배열 첨자를 2개사용하면 2차원 배열
 *   배열 첨자를 3개사용하면 3차원 배열
 *   ...
 *  
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다  (배열첨자 2개 사용)
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다  (배열첨자 3개 사용)
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");

		// 1차원 배열
		int[] arr1 = {1, 2};
		//int arr1[] = {1, 2};   // 가능

		// arr1 <- int[] 타입
		// arr1[0] <- int 타입

		System.out.println();

		// 1차원 배열 x 3개 갖고 있는 2차원 배열
		int[][] array = {
				{1, 2},  // <-- array[0]
				{3, 4},  // <-- array[1]
				{5, 6},  // <-- array[2]
		};

		// array.length  ???
		System.out.println("array.length = " + array.length);  // 2차원배열의 length 는 1차원배열의 개수
		// array[0] => 1차원 배열
		// array[0][0] => 1

		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]);

		// ※ 흔히 2차원 배열을 행과 열로 표현하기도 함
		// array 는 행(row) 3개, 열(column)이 2개인 2차원 배열

		System.out.println("-".repeat(20));
		System.out.println(array[0].length);  // 2

		// array 의 타입은? --> int[][]
		// array[0] 의 타입은? --> int[]
		// array[0][0] 의 타입은? --> int

		// 2차원 배열 + for
		for(int x = 0; x < array.length; x++){  // 첫번째 index 순환

			for(int y = 0; y < array[x].length; y++){  // 두번째 index 순환
				System.out.print(array[x][y] + "\t");
			}
			System.out.println();
		}


		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array05Main









