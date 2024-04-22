// 바구니 뒤집기 ( 정답 )
// 알고리즘: 시뮬레이션, 구현

package boj.simulation;

import java.io.*;
import java.util.*;

public class B2_10811 {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int temp = 0;
            for (int j = 0; j < (end-start+1)/2; j++) {
                temp = arr[start + j];
                arr[start + j] = arr[end - j];
                arr[end - j] = temp;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
