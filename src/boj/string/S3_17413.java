// 단어 뒤집기 2 ( 정답 )
// 알고리즘: 문자열

package boj.string;

import java.io.*;

public class S3_17413 {
    public static String input = "";    // 입력 문자열
    public static String answer = "";   // 출력 문자열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        solution();
        System.out.println(answer);
    }

    public static void solution() {
        String temp = "";       // 단어 또는 태그를 임시 저장
        boolean tag = false;    // 태그 안에 있는지 확인

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {       // 태그가 열리면
                answer += temp;                 // 이전 문자열을 정답에 추가
                temp = "<";                     // temp 초기화
                tag = true;                     // 태그 true
            }
            else if (input.charAt(i) == '>') {  // 태그가 닫히면
                temp += ">";                    // > 추가 후
                answer += temp;                 // 정답에 추가
                temp = "";                      // temp 초기화
                tag = false;                    // 태그 false
            }
            else if (tag) {                     // 태그 내부인 경우
                temp += input.charAt(i);        // 순서대로 추가
            }
            else if (!tag & input.charAt(i) == ' ') {   // 태그 내부가 아니고 공백이면
                answer += temp + " ";                   // 단어 추가
                temp = "";                              // temp 초기화
            }
            else if (!tag) {                    // 태그 내부가 아니면
                temp = input.charAt(i) + temp;  // 단어 앞에 추가해 뒤집기
            }
        }
        answer += temp;     // 남은 temp 추가
    }
}
