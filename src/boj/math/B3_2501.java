// 약수 구하기 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class B3_2501 {

    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count += 1;
                if (count == k) {
                    System.out.println(i);
                    break;
                }
            }
        }

        if (count < k) {
            System.out.println(0);
        }
    }
}
