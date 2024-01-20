// 합분헤 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class G5_2225 {

    static int n, k;    // 0부터 n까지의 정수 k개를 더해 n을 만드는 경우의 수
    static int[][] dp;  // dp[k][n]: 정수 k개를 더해 n을 만드는 경우의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k+1][n+1];

        solution();
    }

    static void solution() {
        // 초기화
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        // k = 2부터 계산
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
             dp[i][j] = getValue(i,j);
            }
        }
        System.out.println(dp[k][n]);
    }

    // dp[k][n] = dp[k-1][n] + dp[k-1][n-1] + ... + dp[k-1][0]
    static int getValue(int x, int y) {
        int sum = 0;
        for (int i = 0; i <= y; i++) {
            sum = (sum + dp[x-1][i]) % 1000000000;
        }
        return sum;
    }
}
