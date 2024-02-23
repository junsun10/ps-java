// 점프 점프 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S3_11060 {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }
        dp[1] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i; j <= i + arr[i]; j++) {
                if (j <= n) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        if (dp[n] == Integer.MAX_VALUE-1) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[n]);
        }
    }
}
