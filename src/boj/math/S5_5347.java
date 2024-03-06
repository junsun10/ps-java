// LCM ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S5_5347 {

    static int n;
    static long a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            solution(a,b);
        }
    }

    static void solution(long x, long y) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(x, y); i++) {
            if (x % i == 0 & y % i == 0) {
                gcd = i;
            }
        }
        long lcm = x * y / gcd;
        System.out.println(lcm);
    }
}
