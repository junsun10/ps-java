// Potato ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_28464 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {

        Arrays.sort(arr);

        int a = 0;
        int b = 0;

        int index = n/2;

        for (int i = 0; i < index; i++) {
            a += arr[i];
        }
        for (int i = index; i < n; i++) {
            b += arr[i];
        }

        System.out.printf("%d %d\n", a, b);
    }
}
