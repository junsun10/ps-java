// 수학은 비대면강의입니다 ( 정답 )
// 알고리즘: 수학, 브루트포스

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class B2_19532 {

    static int a, b, c, d, e, f;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {

        boolean end = false;

        for (int i = -999; i <= 999; i++) {
            if (end) {
                break;
            }
            for (int j = -999; j <= 999 ; j++) {
                if (a*i + b*j == c & d*i + e*j == f) {
                    System.out.printf("%d %d\n", i, j);
                    break;
                }
            }
        }
    }
}
