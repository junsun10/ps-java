// 연속인가?? ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S5_26517 {

    static long n;
    static long a,b,c,d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());

        if (a*n+b == c*n+d) {
            System.out.printf("Yes %d", a*n+b);
        }
        else {
            System.out.println("No");
        }
    }
}
