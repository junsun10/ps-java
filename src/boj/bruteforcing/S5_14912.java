// 숫자 빈도수 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class S5_14912 {

    static int n, d;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp%10 == d) {
                    answer += 1;
                }
                temp /= 10;
            }
        }

        System.out.println(answer);
    }
}
