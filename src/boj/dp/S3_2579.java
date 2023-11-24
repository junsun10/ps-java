// 계단 오르기 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;

public class S3_2579 {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[301];
        dp = new int[301];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution();
    }

    static void solution() {
        dp[1] = arr[1];
        dp[2] = arr[1]+ arr[2];
        for (int i = 3; i <= n; i++) {
            // 한 계단을 올라오는 경우에서 세번 연속 하나씩 올라로는 경우를 제외하기 위해 dp[i-3] + arr[i-1] + arr[i]
            // 두 계단을 올라오는 경우 dp[i-2] + arr[i]
            dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
        }
        System.out.println(dp[n]);
    }
}
