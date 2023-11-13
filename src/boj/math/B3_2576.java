package boj.math;

import java.io.*;

public class B3_2576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minVal = 100;   // 홀수중 최솟값
        int sum = 0;        // 홀수들의 합

        // 자연수 7개 입력
        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n%2 == 1) {         // 홀수인 경우
                sum += n;
                if (n < minVal) {   // 최솟값 갱신
                    minVal = n;
                }
            }
        }
        if (sum == 0) {             // 홀수가 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(minVal);
        }
    }
}
