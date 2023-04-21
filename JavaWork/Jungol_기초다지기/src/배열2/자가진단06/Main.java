package 배열2.자가진단06;

import java.util.Scanner;

/*
85 67 95 65
80 95 86 56
100 98 67 86
95 76 84 65
67 86 90 76

 */
public class Main {
    public static void main(String[] args) {
        // 5명 학생 x 4개 과목 점수 담을 2차원 배열
        int[][] score = new int[5][4];

        Scanner sc = new Scanner(System.in);

        for(int stu = 0; stu < score.length; stu++){
            for(int subj = 0; subj < score[stu].length; subj++){
                score[stu][subj] = sc.nextInt();
            }
        }


        int sum;  // 총점
        double avg;  // 평균
        int success = 0;  // 합격(pass) 한 학생수

        // 학생별로 점수 계산
        for(int stu = 0; stu < score.length; stu++){
            sum = 0;
            // stu 학생의 총점 구하기
            for(int subj = 0; subj < score[stu].length; subj++){
                sum += score[stu][subj];  // stu번째 학생의 subj과목점수 누적 합산
            }
            // stu 학생의 평균 구하기
            avg = (double)sum / score[stu].length;

            //System.out.println(avg);

            if(avg >= 80){
                System.out.println("pass");
                success++;  // 합격판정될때마다 +1 증가
            }else {
                System.out.println("fail");
            }
        }

        // 합격자 수 출력
        System.out.println("Successful : " + success);

        sc.close();
    }
}











