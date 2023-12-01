// 1, 2, 3 더하기 3 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S2_15988 {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        solution();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }

    static void solution() {
        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            // 마지막에 1을 붙여서 만드는 경우, 2를 붙여서 만드는 경우, 3을 붙여서 만드는 경우
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }
    }
}
