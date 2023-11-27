// 거스름돈 ( 정답 )
// 알고리즘: dp, 그리디

package boj.dp;

import java.io.*;

public class S5_14916 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        dp = new int[100001];
        dp[2] = 1;
        dp[5] = 1;
        for (int i = 1; i <= 100000; i++) {

            // i-2원을 낼 수 있는 경우
            // 2원 한개를 더 내면 됨
            if (i-2 >= 2) {
                if (dp[i-2] != 0) {
                    dp[i] = dp[i - 2] + 1;
                }
            }

            // i-5원을 낼 수 있는 경우
            // 5월 한개를 더 내면 됨
            if (i-5 >= 2) {
                if (dp[i-5] != 0) {
                    dp[i] = dp[i - 5] + 1;
                }
            }
        }

        if (dp[n] == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[n]);
        }
    }
}
