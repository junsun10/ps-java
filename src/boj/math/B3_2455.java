// 지능형 기차 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class B3_2455 {
    static int[][] arr = new int[4][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int total = 0;
        int maxVal = 0;
        for (int i = 0; i < 4; i++) {
            total -= arr[i][0];
            total += arr[i][1];
            maxVal = Math.max(total, maxVal);
        }
        System.out.println(maxVal);
    }
}
