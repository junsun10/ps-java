// 링 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S4_3036 {

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
        for (int i = 1; i < n; i++) {
            getGCD(i);
        }
    }

    // 최대 공약수 구해서 정답 출력
    static void getGCD(int index) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(arr[0], arr[index]); i++) {
            if (arr[0] % i == 0 & arr[index] % i == 0) {
                gcd = i;
            }
        }
        System.out.printf("%d/%d\n", arr[0]/gcd, arr[index]/gcd);
    }
}
