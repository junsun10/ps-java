// 백대열 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S5_14490 {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        int min = Math.min(n, m);
        for (int i = min; i > 0 ; i--) {
            if (n % i == 0 & m % i == 0) {
                n /= i;
                m /= i;
            }
        }

        System.out.println(n+":"+m);
    }
}
