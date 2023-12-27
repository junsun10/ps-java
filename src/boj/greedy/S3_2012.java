// 등수 매기기 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S3_2012 {
    static int n;
    static int[] arr;
    static long answer = 0;

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
        Arrays.sort(arr);   // 정렬
        for (int i = 0; i < n; i++) {   // 하나씩 차이 계산
            answer += Math.abs(arr[i] - (i + 1));
        }
        System.out.println(answer);
    }
}