// 에디터 ( 정답 확인 )
// 알고리즘: 스택

package boj.stack;

import java.io.*;
import java.util.*;

public class S2_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> left = new Stack<>();      // 커서 왼쪽을 저장할 스택
        Stack<Character> right = new Stack<>();     // 커서 오른쪽을 저장할 스택

        String start = br.readLine();               // 초기 문자열
        for (int i = 0; i < start.length(); i++) {  // left 스택에 저장
            left.push(start.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());    // n번 명령 입력

        for (int i = 0; i < n; i++) {
            String input = br.readLine();       // 명령어
            Character temp;

            switch (input.charAt(0)) {
                case 'L':   // 커서 왼쪽으로 옮기기
                    if (!left.isEmpty()) {
                        temp = left.pop();
                        right.push(temp);
                    }
                    break;
                case 'D':   // 커서 오른쪽으로 옮기기
                    if (!right.isEmpty()) {
                        temp = right.pop();
                        left.push(temp);
                    }
                    break;
                case 'B':   // 왼쪽 문자 삭제
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P':   // 커서 왼쪽에 문자 추가
                    Character token = input.charAt(2);
                    left.push(token);
                    break;
            }
        }

        // 오른쪽 스택으로 전부 옮김
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        // 버퍼에 하나씩 저장
        while (!right.isEmpty()) {
            bw.write(right.pop());
        }
        bw.write('\n');
        bw.flush();
    }
}
