// 귀찮아(SIB) ( 정답 )
// 알고리즘: 누적 합

package boj.prefix_sum;

import java.io.*;
import java.util.*;

public class S5_14929 {

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
        long answer = 0;
        long temp = 0;

        for (int i = n-2; i >= 0; i--) {
            temp += arr[i+1];
            answer += temp * arr[i];
        }

        System.out.println(answer);
    }
}
