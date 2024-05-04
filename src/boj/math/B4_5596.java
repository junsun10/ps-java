// 시험 점수 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class B4_5596 {

    static int s, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 4; i++) {
            s += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            t += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(s,t));
    }
}
