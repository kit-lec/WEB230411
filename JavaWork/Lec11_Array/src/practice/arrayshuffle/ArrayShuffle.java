package practice.arrayshuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 초간단 배열 섞기

public class ArrayShuffle {
	public static void main(String[] args) {
		String str = "노승현\n" +
				"고태현";
		String [] arr = str.split("\\s+");
		
		List<String> list = Arrays.asList(arr);  // 배열 --> List 로 변환
		Collections.shuffle(list);   // shuffle() 무작위로 섞기

		System.out.println(Arrays.toString(list.toArray()));
	}
}
