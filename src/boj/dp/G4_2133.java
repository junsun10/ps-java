// 타일 채우기 ( 정답 확인)
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class G4_2133 {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() {
        dp = new long[31];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;
        // dp[n] = dp[n-2]*3 + dp[n-4]*2 + ... + dp[0]*2
        for (int i = 6; i < 31; i = i+2) {
            dp[i] = dp[i-2];
            for (int j = 2; j <= i; j = j+2) {
                dp[i] += dp[i-j] * 2;
            }
        }
        System.out.println(dp[n]);
    }
}
