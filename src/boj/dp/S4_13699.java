// 점화식 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.math.BigInteger;

public class S4_13699 {

    static int n;
    static BigInteger[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n+1];

        solution();
    }

    static void solution() {

        dp[0] = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            dp[i] = new BigInteger("0");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i].add(dp[j].multiply(dp[i-j-1]));
            }
        }

        System.out.println(dp[n]);
    }
}
