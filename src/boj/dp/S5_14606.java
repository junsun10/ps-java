// 피자 (Small) ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S5_14606 {

    static int n;
    static int[] dp = new int[11];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 3;
        for (int i = 3; i <= 10; i++) {
            if (i%2 == 0) {
                dp[i] = (i/2) * (i/2) + dp[i/2] + dp[i/2];
            }
            else {
                dp[i] = (i/2) * (i/2 + 1) + dp[i/2] + dp[i/2 + 1];
            }
        }

        System.out.println(dp[n]);

    }
}
