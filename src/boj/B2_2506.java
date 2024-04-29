// 점수계산 ( 정답 )
// 알고리즘: 수학

package boj;

import java.io.*;
import java.util.*;

public class B2_2506 {

    static int answer = 0;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int temp = 0;

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                temp += 1;
                answer += temp;
            }
            else {
                temp = 0;
            }
        }

        System.out.println(answer);
    }
}
