// 돌 게임 2 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S4_9656 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        solution();
    }

    static void solution() {
        // 먼저 하는 사람이 이기면 1, 지면 0
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 0;
            }
            else if (i == 2) {
                dp[i] = 1;
            }
            else if (i == 3) {
                dp[i] = 0;
            }
            else {
                if (dp[i-1] == 0 | dp[i-3] == 0) {
                    dp[i] = 1;
                }
                else {
                    dp[i] = 0;
                }
            }
        }

        if (dp[n] == 0) {
            System.out.println("CY");
        }
        else {
            System.out.println("SK");
        }
    }
}
