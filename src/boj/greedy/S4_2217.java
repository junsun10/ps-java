// 로프 ( 정답 )
// 알고리즘: 그리디, 정렬


package boj.greedy;

import java.io.*;
import java.util.*;

public class S4_2217 {

    static int n;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        answer = arr[n - 1];

        // 로프가 늘어나면 최대 중량이 큰 순서대로 추가함
        // 로프가 늘어나면 로프 하나에 w/k 하중이 가므로
        // 추가한 로프의 최대 중량 * k가 가장 큰 값을 찾음
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, arr[n-i]*i);
        }
        System.out.println(answer);
    }
}
