// 타일 장식물 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S5_13301 {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n];

        solution();
    }

    static void solution() {
        if (n == 1) {
            System.out.println(4);
        }
        else {
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            System.out.println(dp[n - 1] * 4 + dp[n - 2] * 2);
        }
    }
}
