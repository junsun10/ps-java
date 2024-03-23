// Base Conversion ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S5_11576 {

    static int a, b;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int num = 0;

        for (int i = 0; i < m; i++) {
            num += Math.pow(a, m-i-1) * Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while (num > 0) {
            answer.add(num%b);
            num /= b;
        }

        for (int i = answer.size()-1; i >= 0; i--) {
            System.out.printf("%d ", answer.get(i));
        }
        System.out.println();
    }
}
