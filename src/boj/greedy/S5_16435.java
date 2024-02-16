// 스네이크버드 ( 정답 )
// 알고리즘: 정렬, 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_16435 {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] <= m) {
                m += 1;
            }
        }
        System.out.println(m);
    }
}
