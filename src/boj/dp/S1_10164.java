// 격자상의 경로 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S1_10164 {
    static int n,m,k;
    static int[] p = new int[2];
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][m+1];

        p[0] = k / m + 1;
        p[1] = k % m;
        if (p[1] == 0) {
            p[0] -= 1;
            p[1] = m;
        }

        dp[0][1] = 1;

        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        else {
            for (int i = 1; i <= p[0]; i++) {
                for (int j = 1; j <= p[1]; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            for (int i = p[0]; i <= n; i++) {
                for (int j = p[1]; j <= m; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

        }
        System.out.println(dp[n][m]);
    }
}
