// 사탕 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_11256 {

    static int N, J;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            J = Integer.parseInt(st.nextToken());
            arr = new int[J];

            for (int j = 0; j < J; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[j] = x * y;
            }

            solution();
        }
    }

    static void solution() {
        Arrays.sort(arr);

        int sum = 0;
        int count = 0;
        for (int i = J-1; i >= 0; i--) {
            if (sum >= N) {
                System.out.println(count);
                break;
            }
            else {
                sum += arr[i];
                count += 1;
            }
        }
    }
}
