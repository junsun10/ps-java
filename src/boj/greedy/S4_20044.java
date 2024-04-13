// Project Teams ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S4_20044 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[2*n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2*n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {

        Arrays.sort(arr);

        int minValue = arr[0] + arr[2*n-1];

        for (int i = 0; i < n; i++) {
            if (arr[i] + arr[2*n-i-1] < minValue) {
                minValue = arr[i] + arr[2*n-i-1];
            }
        }

        System.out.println(minValue);
    }
}
