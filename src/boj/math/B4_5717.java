// 상근이의 친구들 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class B4_5717 {

    static int m, f;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            m = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken());

            if (m == 0 & f == 0) {
                break;
            }
            else {
                System.out.println(m+f);
            }
        }
    }
}
