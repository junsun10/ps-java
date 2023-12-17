// 소수 구하기 ( 정답 )
// 알고리즘: 에라토스테네스의 체

package boj.math;

import java.io.*;
import java.util.*;

public class S3_1929 {
    static int m,n;
    static boolean[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        arr = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                if (i >= m) {
                    System.out.println(i);
                }
                for (int j = i; j <= n; j=j+i) {
                    arr[j] = true;
                }
            }
        }
    }
}
