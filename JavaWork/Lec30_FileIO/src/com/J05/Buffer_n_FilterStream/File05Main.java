package com.J05.Buffer_n_FilterStream;

/* Buffered Stream + Buffer 예제
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream
*/

import java.io.*;

public class File05Main {

	public static void main(String[] args) {
		System.out.println("Buffered Stream + Buffer");
		
		// TODO:
		// file03 패키지 참조
		// try with resource 구문으로 작성
		// in.read(buff) --> bin.read(buff);
		// out.write( , , ) --> bout.write( , , ); 사용
		// finally 필요 없슴


		try(
				InputStream in = new FileInputStream("temp/big_text.txt");
				BufferedInputStream bin = new BufferedInputStream(in);
				OutputStream out = new FileOutputStream("temp/copy_big_text.txt");
				BufferedOutputStream bout = new BufferedOutputStream(out);
		) {

			byte[] buff = new byte[1024];  // 버퍼 준비

			int lengthRead = 0;  // 읽은 바이트수
			int bytesCopied = 0;
			long startTime = System.currentTimeMillis();   // 현재시간 저장

			while(true){
				// 매개변수로 주어진 byte[] 배열의 길이 만큼 read한다.
				// 실제 읽어 들인 데이터는 매개변수 byte[] 에 담김.
				// 읽어들인 바이트 개수 리턴,  읽어들인게 없으면 -1 리턴
				lengthRead = bin.read(buff);
				if(lengthRead == -1){
					break;
				}
				bout.write(buff, 0, lengthRead);   // 직전에 읽어들인 데이터 만큼 출력

				bytesCopied += lengthRead;

			} // end while

			long endTime = System.currentTimeMillis();   // 끝난시간
			long elapsedTime = endTime - startTime;  // 경과시간

			System.out.println("읽고 쓴 바이트: " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);


		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class File05Main
















