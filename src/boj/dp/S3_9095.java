// 1,2,3 더하기 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S3_9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t, n;

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            solution();
        }
    }

    static void solution() {
        int[] dp = new int[Math.max(n+1,4)];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];    // 마지막에 1을 더하는 경우, 2를 더하는 경우, 3을 더하는 경우
        }
        System.out.println(dp[n]);
    }
}
