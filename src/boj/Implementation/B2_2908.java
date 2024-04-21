// 상수 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class B2_2908 {

    static String n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = st.nextToken();
        m = st.nextToken();

        solution();
    }

    static void solution() {

        String newN = "" + n.charAt(2) + n.charAt(1) + n.charAt(0);
        String newM = "" + m.charAt(2) + m.charAt(1) + m.charAt(0);

        int intN = Integer.parseInt(newN);
        int intM = Integer.parseInt(newM);

        System.out.println(Math.max(intN, intM));
    }
}
