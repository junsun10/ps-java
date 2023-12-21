// 꿀 따기 ( 정답 )
// 알고리즘: 그리디, 누적합

package boj.greedy;

import java.io.*;
import java.util.*;


public class G5_21758 {
    static int n;
    static int[] arr;
    static int[] sum;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        sum = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        solution();
    }

    static void solution() {
        right();    // 맨 오른쪽 벌통, 맨 왼쪽 벌, 중간에 벌
        left();     // 맨 왼쪽 벌통, 맨 오른쪽 벌, 중간에 벌
        mid();      // 양 끝에 벌, 중간에 벌통
        System.out.println(answer);
    }

    static void right() {
        for (int i = 2; i < n; i++) {
           answer = Math.max(answer, sum[n] - arr[1] - arr[i] + sum[n] - sum[i]);
        }
    }

    static void left() {
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, sum[n-1] - arr[i] + sum[i-1]);
        }
    }

    static void mid() {
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, sum[i] - sum[1] + sum[n-1] - sum[i-1]);
        }
    }

}
