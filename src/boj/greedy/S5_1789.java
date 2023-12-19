// 수들의 합 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;

public class S5_1789 {
    static long s, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
        long i = 1;
        long temp = s;
        while (true) {
            if (temp - i >= 0) {
                answer += 1;
                temp -= i;
                i++;
            }
            else {
                break;
            }
        }
        System.out.println(answer);
    }
}
