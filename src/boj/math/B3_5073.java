// 삼각형과 세 변 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class B3_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 & b == 0 & c == 0) {
                break;
            }

            int[] list = {a, b, c};
            Arrays.sort(list);

            if (list[2] >= list[0] + list[1]) {
                System.out.println("Invalid");
            } else if (a == b & b == c) {
                System.out.println("Equilateral");
            } else if ((a == b & b != c) | (a == c & a != b) | (b == c & a != b)) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
