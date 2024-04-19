// 피보나치 수 5 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class B2_10870 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        solution();
    }

    static void solution() {

        if (n >= 1) {
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[n]);
    }
}
