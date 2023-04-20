package com.lec.java.j10_02_continue;

/* continue;
 * 순환문(for, while, do~while) 안에서 continue   를 만나면
 * continue를 감싸는 가장 가까운 순환문 으로 돌아감
 * 
 * 순환문은 종료하지 않고 . 특정 조건만 스킵!
 */

public class Loop02Main {

	public static void main(String[] args) {
		System.out.println("continue;");

		int num = 1;
		while(num <= 10){
			num++;

			if(num % 2 == 0)
				continue;  // 짝수인 경우만 continue

			System.out.println(num);
		}

		// for 문으로 무한루프 만들기
		for(int count = 1;; count++){
			if(count > 10) break;
			if(count % 2 == 1) continue;
			System.out.println("안녕하세요..." + count);
		}


		System.out.println();
		// for문과 continue를 사용해서
		// 1 ~ 10 숫자 중 짝수만 출력

		// TODO

		System.out.println();
		// 2단은 x 2 부터 출력
		// 3단은 x 3 부터 출력

		// TODO


		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















