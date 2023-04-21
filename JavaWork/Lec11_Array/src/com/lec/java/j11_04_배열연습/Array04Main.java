package com.lec.java.j11_04_배열연습;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");

		// 주어진 배열에서 '최댓값', '최솟값' 찾기

		int[] scores = {45, 65, 23, 87, 73};

		// 최댓값
		int max = scores[0];
		for(int i = 1; i < scores.length; i++){  // 두번째 원소부터 비교
			if(scores[i] > max){
				max = scores[i];  // i번째 점수와 max값 비교해서 더 큰값을 max에 담기
			}
		}
		System.out.println("최댓값: " + max);

		int min = scores[0];
		for(int i = 1; i < scores.length; i++){  // 두번째 원소부터 비교
			if(scores[i] < min){
				min = scores[i];  // i번째 점수와 max값 비교해서 더 큰값을 max에 담기
			}
		}
		System.out.println("최솟값: " + min);



		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array04Main








