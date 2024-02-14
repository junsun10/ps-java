// 수들의 합 5 ( 정답 )
// 알고리즘: 두 포인터

package boj.two_pointer;

import java.io.*;

public class S5_2018 {
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        int start = 1;
        int end = 1;
        int now = 1;
        while (start <= end) {
            if (now == n) {
                answer += 1;
                now -= start;
                start += 1;

            }
            else if (now < n) {
                end += 1;
                now += end;
            }
            else {
                now -= start;
                start += 1;
            }
        }

        System.out.println(answer);
    }
}
