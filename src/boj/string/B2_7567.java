// 그릇 ( 정답 )
// 알고리즘: 구현, 문자열

package boj.string;

import java.io.*;

public class B2_7567 {

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        answer += 10;
        char before = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == before) {
                answer += 5;
            }
            else {
                answer += 10;
            }
            before = input.charAt(i);
        }

        System.out.println(answer);
    }
}
