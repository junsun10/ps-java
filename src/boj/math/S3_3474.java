// 교수가 된 현우 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;

public class S3_3474 {
    static int t;
    static long[] input;
    static long c5; // n!에서 5의 개수

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        input = new long[t];
        for (int i = 0; i < t; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        solution();
        bw.flush();
    }

    static void solution() throws Exception {
        for (long x : input) {
            c5 = 0;
            for (int i = 5; i <= x; i*=5) {
                c5 += x / i;
            }
            bw.write(c5 + "\n");    // n!에서 5의 개수가 0의 개수
        }
    }
}
