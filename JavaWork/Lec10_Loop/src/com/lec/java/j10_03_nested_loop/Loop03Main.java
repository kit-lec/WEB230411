package com.lec.java.j10_03_nested_loop;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 2단 ~ 9단

		// 2 x 1 = 2
		// ..
		// 2 x 9 = 18
		// 3 x 1 = 3
		// ..
		// 3 x 9 = 27
		// ...
		// 9 x 1 = 9
		// ..
		// 9 x 9 = 81

		// 구구단 출력 : 중첩 for 사용
		for(int dan = 2; dan <= 9; dan++){   // 2단 ~ 9단
			System.out.println(dan + "단");
			for(int mul = 1; mul <= 9; mul++){  // x1 ~ x9
				System.out.println(dan + " x " + mul + " = " + (dan * mul) );
			}
			System.out.println();
		}

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		// 구구단 출력 : 중첩 while 문 사용
		// by 김도연
		{
			int dan = 2;
			while (dan <= 9) {
				int mul = 1;
				System.out.println(dan + "단");
				while (mul <= 9) {
					System.out.println(dan + " x " + mul + " = " + (dan * mul));
					mul++;
				}
				dan++;
				System.out.println();
			}
		}
		System.out.println();

		// 구구단 출력 : 중첩 while 문 사용
		// 이동화
		{
			int dan = 2;
			while (dan <= 9) { //2단 ~ 9단
				System.out.println(dan + "단");
				int mul = 1;

				while (mul <= 9) { // x1 ~ x9
					System.out.println(dan + " x " + mul + " = " + (dan * mul));
					mul++;
				}

				System.out.println();
				dan++;
			}
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















