// 팔찌 만들기 ( 정답 )
// 알고리즘: 정렬, 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_25707 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int answer = 0;
        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            answer += Math.abs(arr[i-1] - arr[i]);
        }
        answer += Math.abs(arr[n-1] - arr[0]);

        System.out.println(answer);
    }
}
