// 안테나 ( 정답 )
// 알고리즘: 그리디, 정

package boj.greedy;

import java.io.*;
import java.util.*;

public class S3_18310 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (n == 1) {
            System.out.println(arr[1]);
        }
        else {
            Arrays.sort(arr);
            if (n%2 == 0) {     // 짝수면 중간의 왼쪽
                System.out.println(arr[n/2]);
            }
            else {              // 홀수면 중간
                System.out.println(arr[n/2+1]);
            }
        }
    }
}
