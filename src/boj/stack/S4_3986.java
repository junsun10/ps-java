// 좋은 단어 ( 정답 )
// 알고리즘: 스택

package boj.stack;

import java.io.*;
import java.util.*;

public class S4_3986 {

    static int n;
    static String input;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            input = br.readLine();

            solution();
        }

        System.out.println(answer);
    }

    static void solution() {
        ArrayDeque<Character> dq = new ArrayDeque<>();

        dq.add(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (dq.isEmpty()) {
                dq.push(input.charAt(i));
            }
            else {
                Character top = dq.peek();
                if (top == input.charAt(i)) {
                    dq.pop();
                } else {
                    dq.push(input.charAt(i));
                }
            }
        }

        if (dq.isEmpty()) {
            answer += 1;
        }
    }
}
