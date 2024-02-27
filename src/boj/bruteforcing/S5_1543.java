// 문서 검색 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;

public class S5_1543 {
    static String a, b;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

        solution();
    }

    static void solution() {
        int start = 0;
        while (start + b.length() <= a.length()) {
            boolean check = false;
            for (int i = 0; i < b.length(); i++) {
                if (a.charAt(start + i) != b.charAt(i)) {
                    break;
                }
                if (i == b.length() - 1) {
                    check = true;
                }
            }
            if (check) {
                start += b.length();
                answer += 1;
            }
            else {
                start += 1;
            }
        }
        System.out.println(answer);
    }
}
