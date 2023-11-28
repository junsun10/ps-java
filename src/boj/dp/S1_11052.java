// 카드 구매하기 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S1_11052 {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            // dp[i] = max((dp[0]+arr[i]), (dp[1]+arr[i-1]), ... , (dp[i-1]+arr[1]))
            for (int j = 0; j < i; j++) {
                max = Math.max(dp[j]+arr[i-j], max);
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);
    }
}
