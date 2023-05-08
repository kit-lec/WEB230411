package com.J04.FilterStream;

/* 보조스트림 (filter stream)
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

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

import java.io.*;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null;
		BufferedInputStream bin = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;

		try {
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in); // 장착!

			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out);  // 장착!


			int dataRead;
			int bytesCopied = 0;
			long startTime = System.currentTimeMillis();   // 현재시간 저장

			while(true){
				dataRead = bin.read();
				if(dataRead == -1){
					break;
				}
				bout.write(dataRead);

				bytesCopied++;

			} // end while

			long endTime = System.currentTimeMillis();   // 끝난시간
			long elapsedTime = endTime - startTime;  // 경과시간

			System.out.println("읽고 쓴 바이틑: " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);


		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			// 리소스 해제
			try {
				if(bout != null) bout.close();
				if(bin != null) bin.close();  // bin을 close하면, bin을 만든 in도 함께 close됨
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














