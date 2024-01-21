// 하노이 탑 ( 정답 )
// 알고리즘: 큰 수, 재귀
// dp[n] = dp[n-1] + 1 + dp[n-1]

package boj.math;

import java.io.*;
import java.math.BigInteger;

public class S1_1914 {
    static int n;
    static BigInteger[] dp;
    static BigInteger answer = new BigInteger("0");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n+1];

        solution();
    }

    static void solution() {
        count();
        if (n <= 20) {
            re(n, 1, 2, 3);
        }
    }

    static void count() {
        dp[0] = BigInteger.valueOf(0);
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i-1].add(dp[i-1])).add(BigInteger.valueOf(1));
        }
        System.out.println(dp[n]);
    }

    static void re(int count, int a, int b, int c) {
        if (count >= 1) {
            re(count-1, a, c, b);
            System.out.println(a + " " + c);
            re(count-1, b, a, c);
        }
    }
}
