// 최소공배수 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S5_13241 {

    static long a, b;
    static long temp;   // 최대공약수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        solution();
    }

    static void solution() {
        long minVal = Math.min(a, b);

        for (int i = 1; i <= minVal; i++) {
            if (a % i == 0 & b % i == 0 ) {
                temp = i;
            }
        }
        long answer = temp * (a/temp) * (b/temp);   // 최소공배수
        System.out.println(answer);
    }
}
