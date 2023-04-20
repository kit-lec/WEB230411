package com.lec.java.j08_02_구구단;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");

//		구구단 2단
//		2 x 1 = 2
//		2 x 2 = 4
//		2 x 3 = 6
//		2 x 4 = 8
//		2 x 5 = 10
//		2 x 6 = 12
//		2 x 7 = 14
//		2 x 8 = 16
//		2 x 9 = 18

		System.out.println();
		System.out.println("구구단 2단");

		for(int m = 1; m <= 9; m++){
			System.out.printf("2 x %d = %d\n", m, 2 * m);
		}

		System.out.println("구구단 2단");

		for(int m = 1; m < 10; m++)
			System.out.printf("2 x %d = %d\n", m, 2 * m);


	} // end main()

} // end class For02Main












