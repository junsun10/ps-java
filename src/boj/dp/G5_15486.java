// 퇴사 2 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class G5_15486 {
    public static int n;        // 남은 일 수
    public static int[][] arr;  // 상담 일정
    public static int[] dp;     // 날짜별 최대 이익 저장
    public static int answer;   // 최대 이익

    public static void main(String[] args) throws Exception{
        read();
        solution();
        System.out.println(answer);
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][2];  // [기간,수익]
        dp = new int[n+1];

        // 상담 일정 저장
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int t = Integer.parseInt(st.nextToken());   // 상담에 걸리는 기간
            int p = Integer.parseInt(st.nextToken());   // 수익
            arr[i] = new int[]{t,p};
        }
    }

    // 풀이 함수
    public static void solution() {
        for (int i = 1; i <= n; i++) {
            int plusDay = arr[i][0];    // 오늘 받을 상담에 걸리는 기간
            int pay = arr[i][1];        // 오늘 받을 상담 수익

            // 마지막날까지 상담 가능
            if (i + plusDay <= n+1) {
                // 오늘 받은 상담이 끝나는 날 수익 = max(이전까지 최대 수익 + 오늘 상담 수익, 오늘 받은 상담이 끝나는 날 수익)
                dp[i+plusDay-1] = Math.max(answer + pay, dp[i+plusDay-1]);
            }
            answer = Math.max(dp[i], answer);   // 오늘까지 최대 수익 갱신
        }
    }
}
