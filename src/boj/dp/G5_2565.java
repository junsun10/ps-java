// 전깃줄 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class G5_2565 {
    static int n;
    static int[][] arr;
    static int answer = 0;

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        // 전깃줄 목록을 B 번호 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 정렬된 목록에서
        // DP를 사용해 A 번호 기준 가장 긴 증가하는 부분 수열을 찾으면
        // 전깃줄이 교차하지 않는 최대 개수를 찾을 수 있음
        // n - 최댓값이 정답

        dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(dp[i], answer);
        }
        answer = n - answer;
        System.out.println(answer);
    }
}
