// 알바생 강호 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S4_1758 {

    static int n;
    static Integer[] arr;
    static Long tip = 0L;

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

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            tip += Math.max(0, arr[i] - i);
        }

        System.out.println(tip);
    }
}
