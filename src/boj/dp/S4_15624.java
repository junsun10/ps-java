// 피보나치 수 7 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S4_15624 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        solution();
    }

    static void solution() {

        if (n == 0) {
            System.out.println(0);
            return;
        }

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        System.out.println(dp[n]);
    }
}
