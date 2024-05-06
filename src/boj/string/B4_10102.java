// 개표 ( 정답 )
// 알고리즘: 문자열

package boj.string;

import java.io.*;

public class B4_10102 {

    static int v;
    static int a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());

        String input = br.readLine();

        for (int i = 0; i < v; i++) {
            if (input.charAt(i) == 'A') {
                a += 1;
            }
            else {
                b += 1;
            }
        }

        if (a == b) {
            System.out.println("Tie");
        } else if (a > b) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}
