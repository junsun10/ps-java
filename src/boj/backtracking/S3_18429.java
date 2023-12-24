// 근손실 ( 정답 )
// 알고리즘: 백트래킹, 브루트포스

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S3_18429 {
    static int n, k;        // n: 전체 운동 날짜, k: 감소 중량
    static int[] arr;       // 중량 증가량 배열
    static boolean[] visited;   // 키트 사용 여부
    static int w = 500;     // 중량
    static int answer = 0;  // 가능한 경우의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int d) {
        if (d == n) {           // 마지막날 중량이 500이 넘으면 정답 증가
            if (w >= 500) {
                answer += 1;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int temp = arr[i] - k;
                if (w + temp >= 500) {
                    w += temp;
                    visited[i] = true;
                    dfs(d+1);
                    w -= temp;
                    visited[i] = false;
                }
            }
        }

    }
}
