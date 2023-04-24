package com.lec.java.j12_10_메소드와배열;

import java.util.Scanner;

/* 메소드와 배열
 * 매개변수가 배열,  리턴타입이 배열
 */
public class Method10Main {

	public static void main(String[] args) {
		System.out.println("메소드와 배열");
		Scanner sc = new Scanner(System.in);

		// 배열선언
		int[] score = new int[5];

		// 점수를 입력받아서 score 배열에 저장
		inputScore(sc, score);   // 배열을 매개변수로 전달

		// 점수 확인
		displayScore(score);

		int[] newArr = doubleUp(score);
		displayScore(newArr);

		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

	// method name: inputScore
	// return: void
	// arguments:
	//   1) Scanner sc - 입력장치
	//   2) int[] score: 점수를 입력받아서 저장할 배열
	public static void inputScore(Scanner sc, int[] score){
		System.out.println("length: " + score.length);

		for(int i = 0; i < score.length; i++){
			System.out.print("점수" + (i + 1) + " 입력: ");
			score[i] = sc.nextInt();
		}
	}

	// method name: displayScore
	// return: void
	// arguments: int[] score - 출력할 점수가 저장된 배열
	public static void displayScore(int[] score){
		System.out.println("[점수 출력]");
		for(var x : score){
			System.out.print(x + ", ");
		}
		System.out.println();
	}

	// method name: calcTotal
	// return: int (계산된 총점을 리턴)
	// arguments: int[] score (점수들을 저장한 배열)
	// TODO


	// method name: findMax
	// return: int (최대값)
	// arguments: int[] score (점수들 저장된 배열)
	// TODO


	// method name: findMin()
	// return: int (최소값)
	// arguments: int[] score
	// TODO

	// method name: doubleUp()
	// return: int[]  (생성된 배열)
	// arguments: int[] (입력 배열)
	//   입력된 배열의 원소들을 x2 를 한 새로운 배열 생성하여 리턴

	public static int[] doubleUp(int[] arr){
		int[] result = new int[arr.length];

		for(int i = 0; i < arr.length; i++){
			result[i] = arr[i] * 2;
		}

		return result;
	}

} // end class Method09Main












