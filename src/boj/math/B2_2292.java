// 벌집 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;

public class B2_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        n -= 1;
        int i = 0;
        while (true) {
            n -= i*6;
            if (n <= 0) {
                System.out.println(i+1);
                break;
            }
            else {
                i += 1;
            }
        }
    }
}
