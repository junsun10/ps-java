// ZOAC 4 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class B3_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x;
        int y;

        x = h/(n+1);
        if (h%(n+1) > 0) {
            x += 1;
        }
        y = w/(m+1);
        if (w%(m+1) > 0) {
            y += 1;
        }
        System.out.println(x*y);
    }
}
