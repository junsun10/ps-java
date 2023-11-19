// 귀찮음 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_16208 {
    public static int n;
    public static long total;
    public static int[] arr;
    public static long answer;

    public static void main(String[] args) throws Exception {
        read();
        solution();
        System.out.println(answer);
    }

    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
    }

    public static void solution() {
        Arrays.sort(arr);
        // 큰 막대부터 자르기
        for (int i = n-1; i > 0; i--) {
            answer += arr[i] * (total - arr[i]);
            total -= arr[i];
        }
    }
}
