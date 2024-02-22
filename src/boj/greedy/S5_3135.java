// 라디오 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_3135 {

    static int a, b;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        int answer = Math.max(a - b, b - a);

        for (int i : arr) {
            if (Math.max(i - b, b - i) + 1 < answer) {
                answer = Math.max(i - b, b - i) + 1;
            }
        }
        System.out.println(answer);
    }
}
