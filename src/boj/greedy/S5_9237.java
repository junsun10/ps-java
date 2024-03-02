// 이장님 초대 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_9237 {
    static int n;
    static Integer[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        Arrays.sort(arr, Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i] + i + 2);
        }
        System.out.println(max);
    }
}
