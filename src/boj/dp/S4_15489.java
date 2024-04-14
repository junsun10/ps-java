// 파스칼 삼각형 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S4_15489 {

    static int r, c, w;
    static int[][] dp;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        dp = new int[r+w+1][r+w+1];

        solution();
    }

    static void solution() {

        dp[0][0] = 1;

        for (int i = 1; i <= r+w; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                answer += dp[i+r][j+c];
            }
        }

        System.out.println(answer);
    }
}
