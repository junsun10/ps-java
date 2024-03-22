// 2+1 세일 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S4_11508 {

    static int n;
    static Integer[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr, Comparator.reverseOrder());

        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += arr[i];
            if (i % 3 == 2) {
                answer -= arr[i];
            }
        }

        System.out.println(answer);
    }
}
