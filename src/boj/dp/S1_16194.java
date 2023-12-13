// 카드 구매하기 2 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S1_16194 {
    static int n;
    static int[] arr;   // 카드 가격
    static int[] dp;    // 구매 가격 최솟값

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
        // 1개 부터 n개 까지 구매 가격 최솟값 구하기
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;    // 최솟값
            for (int j = 1; j <= i; j++) {  // 1 ~ i 카드중 하나 선택, 그 중 최솟값
                if (i-j >= 0) {
                    min = Math.min(dp[i-j] + arr[j], min);
                }
            }
            dp[i] = min;
        }
        System.out.println(dp[n]);
    }
}
