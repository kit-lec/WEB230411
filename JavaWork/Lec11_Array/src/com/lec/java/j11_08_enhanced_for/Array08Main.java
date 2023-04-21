package com.lec.java.j11_08_enhanced_for;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array08Main {

	public static void main(String[] args) {
		System.out.println("Enhanced for (향상된 for) 문");

		String [] arr;
		arr = new String[]{
				"Java", "C언어", "C#", "Python", "JavaScript",
		};

		for(String x : arr){
			System.out.print(x + " ");
		}
		System.out.println();

		System.out.println("2차원 배열 + enhanced-for");

		int[][] array = new int[3][];   // 1차원 배열 x 3개 인 2차원 배열로 초기화

		array[0] = new int[]{1, 2};    // 각각의 1차원배열의 length 는 제각각이어도 관계없슴. (ragged-array, jagged-array)
		array[1] = new int[]{3, 4, 5, 6};
		array[2] = new int[]{7, 8, 9};

		int[][] array2 = {
				{1, 2},
				{3, 4, 5, 6},
				{7, 8, 9},
		};

		for(int[] row : array){

			for(int x : row){
				System.out.print(x + " ");
			}
			System.out.println();
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array10Main









