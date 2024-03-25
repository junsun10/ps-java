// 짐 챙기는 숌 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_1817 {

    static int n, m;
    static int[] arr;
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] <= m) {
                sum += arr[i];
            }
            else {
                answer += 1;
                sum = arr[i];
            }
        }

        System.out.println(answer);
    }
}
