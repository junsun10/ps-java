// 뒤집기 ( 정답 )
// 알고리즘: 그리디, 문자열

package boj.greedy;

import java.io.*;

public class S5_1439 {
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        solution();
    }

    static void solution() {
        int count0 = 0;
        int count1 = 0;
        int before = Integer.parseInt(Character.toString(s.charAt(0)));
        if (before == 0) {
            count0 += 1;
        }
        else {
            count1 += 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) ==  '0') {
                if (before == 1) {
                    count0 += 1;
                    before = 0;
                }
            }
            if (s.charAt(i) == '1') {
                if (before == 0) {
                    count1 += 1;
                    before = 1;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}
