// 포켓몬 GO ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S5_13717 {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        String answer = "";
        int total = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int c = 0;
            while (true) {
                if (m >= k) {
                    total += 1;
                    c += 1;
                    m = m - k + 2;
                }
                else {
                    break;
                }
            }
            if (c > count) {
                count = c;
                answer = name;
            }
        }

        System.out.println(total);
        System.out.println(answer);
    }
}
