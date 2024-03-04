// 피보나치 수 4 ( 정답 )
// 알고리즘: dp, 큰 수

package boj.dp;

import java.io.*;
import java.math.BigInteger;

public class S5_10826 {

    static int n;
    static BigInteger[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n+1];

        solution();
    }

    static void solution() {
        if (n <= 1) {
            System.out.println(n);
        }
        else {
            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1].add(dp[i-2]);
            }
            System.out.println(dp[n]);
        }
    }
}
