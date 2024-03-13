// 칠무해 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_14729 {

    static int n;
    static float[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new float[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Float.parseFloat(br.readLine());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        for (int i = 0; i < 7; i++) {
            System.out.printf("%.3f\n", arr[i]);
        }
    }
}
