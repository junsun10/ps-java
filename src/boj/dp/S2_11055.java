// 가장 큰 증가하는 부분 수열 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S2_11055 {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        dp[0] = arr[0]; // 기본값
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {               // 0번째부터 i 이전까지
                if (arr[j] < arr[i] & dp[j] > max) {    // i 보다 작고 합이 가장 크면
                    max = dp[j];    // 임시 저장
                }
            }
            dp[i] = max + arr[i];   // 증가하는 부분 수열 중 합이 가장 큰 값 + i 값
        }

        int answer = 0; // 최댓값 저장
        for (int i = 0; i < n; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}
