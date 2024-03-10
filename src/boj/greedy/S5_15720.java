// 카우버거 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_15720 {

    static int b, c, d;
    static int[] B, C, D;
    static int total = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        B = new int[b];
        C = new int[c];
        D = new int[d];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            total += B[i];
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < c; i++) {
            C[i] = Integer.parseInt(st.nextToken());
            total += C[i];
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < d; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            total += D[i];
        }

        solution();
    }

    static void solution() {

        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        int one = 0;

        int min = Math.min(d, Math.min(b, c));

        for (int i = 0; i < b - min; i++) {
            one += B[i];
        }
        for (int i = 0; i < c - min; i++) {
            one += C[i];
        }
        for (int i = 0; i < d - min; i++) {
            one += D[i];
        }

        System.out.println(total);
        System.out.println((int)((total-one)*0.9 + one));
    }
}
