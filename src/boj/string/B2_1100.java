// 하얀 칸 ( 정답 )
// 알고리즘: 문자열

package boj.string;

import java.io.*;

public class B2_1100 {

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            String input = br.readLine();

            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0 & input.charAt(j) == 'F') {
                        answer += 1;
                    }
                }
            }
            else {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 1 & input.charAt(j) == 'F') {
                        answer += 1;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
