// 2xn 타일링 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S3_11726 {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[Math.max(n+1,3)];
        solution();
    }

    static void solution() {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;  // 이전 + 세로블럭, 두개 전 + 가로블럭 두개
        }
        System.out.println(dp[n]);
    }
}
