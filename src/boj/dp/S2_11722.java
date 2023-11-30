// 가장 긴 감소하는 부분 수열 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S2_11722 {
    static int n;
    static int[] arr, dp;

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
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j < i; j++) {               // i 보다 앞에서
                if (arr[j] > arr[i] & dp[j] > count) {  // arr[i]보다 크고 dp[j]가 최대인 값 찾기
                    count = dp[j];
                }
            }
            dp[i] = count + 1;
        }

        int answer = 1;
        for (int i : dp) {
            if (i > answer) {
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
