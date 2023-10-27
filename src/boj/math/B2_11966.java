// 2의 제곱인가? ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;

public class B2_11966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        boolean check = false;

        while (start <= n) {
            if (start == n) {
                System.out.println(1);
                check = true;
                break;
            }
            else {
                start *= 2;
            }
        }
        if (!check) {
            System.out.println(0);
        }
    }
}
