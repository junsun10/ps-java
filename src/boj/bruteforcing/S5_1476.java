// 날짜 계산 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class S5_1476 {

    static int e, s, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        int answer = 1;
        while (true) {
            if ((answer % 15 == 0 & e == 15) | (answer % 15 == e)) {
                if ((answer % 28 == 0 & s == 28) | (answer % 28 == s)) {
                    if ((answer % 19 == 0 & m == 19) | (answer % 19 == m)) {
                        break;
                    }
                }
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}
