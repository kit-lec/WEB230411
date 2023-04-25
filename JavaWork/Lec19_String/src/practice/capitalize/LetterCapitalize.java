package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my WORLD
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str;
		String[] words;

		while(true){
			str = sc.nextLine();
			if(str.trim().equalsIgnoreCase("quit")) break;

			str = str.trim().toLowerCase();
			words = str.split("\\s+");

			for(String word : words){
				// 맨 앞글자는 대문자로
				String firstLetter = word.substring(0, 1).toUpperCase();
				// 나머지 문자열
				String rest = word.substring(1);
				System.out.print(firstLetter + rest + " ");
			}
			System.out.println();
		}

		sc.close();
	} // end main()
} // end class












