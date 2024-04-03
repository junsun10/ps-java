// BABBA ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S5_9625 {

    static int n;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2];

        solution();
    }

    static void solution() {
        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }

        System.out.printf("%d %d\n", dp[n][0], dp[n][1]);
    }

}
