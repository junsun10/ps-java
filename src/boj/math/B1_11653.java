// 소인수분해 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;

public class B1_11653 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n%i == 0) {
                    System.out.println(i);
                    n /= i;
                    break;
                }
            }
        }
    }
}
