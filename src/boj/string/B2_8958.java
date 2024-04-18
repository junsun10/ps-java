// OX퀴즈 ( 정답 )
// 알고리즘: 문자열

package boj.string;

import java.io.*;

public class B2_8958 {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            solution(input);
        }
    }

    static void solution(String input) {

        int answer = 0;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'O') {
                count += 1;
                answer += count;
            }
            else {
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
