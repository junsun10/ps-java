// 모음의 개수 ( 정답 )
// 알고리즘: 문자열

package boj.string;

import java.io.*;

public class B4_1264 {
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            answer = 0;
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            else {
                for (int i=0; i<input.length(); i++) {
                    if (input.charAt(i) == 'a' | input.charAt(i) == 'e' | input.charAt(i) == 'i' | input.charAt(i) == 'o' | input.charAt(i) == 'u'
                    | input.charAt(i) == 'A' | input.charAt(i) == 'E' | input.charAt(i) == 'I' | input.charAt(i) == 'O' | input.charAt(i) == 'U') {
                        answer += 1;
                    }
                }
                System.out.println(answer);
            }
        }
    }
}
