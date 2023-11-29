// 줄어들지 않아 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S1_2688 {
    static int t;
    static int n;
    static long[][] dp;
    static long[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        answer = new long[65];
        answer[1] = 10;
        dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        solution();

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(answer[n]);
        }
    }

    static void solution() {
        for (int i = 2; i <= 64; i++) {
            long sum = 0;
            long temp = answer[i-1];        // i-1 정답값에서
            for (int j = 0; j < 10; j++) {
                sum += temp;
                dp[i][j] = temp;
                temp -= dp[i-1][j];         // dp[i-1][j] 빼면서 dp 채우기
            }
            answer[i] = sum;
        }
    }
}
