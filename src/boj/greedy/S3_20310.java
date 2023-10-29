// 타노스 ( 정답 )
// 알고리즘: 그리디
// 문자열에 0과 1의 개수를 센 뒤
// 앞에서부터 0이면 절반이 될 때까지 정답에 추가
// 1이면 절반만큼 넘긴 뒤 추가

package boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S3_20310 {
    public static String str;   // 입력 문자열

    public static void main(String[] args) throws Exception {
        read();     // 입력 합수
        solution(); // 풀이 함수
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

    // 풀이 함수
    public static void solution() {
        String answer = ""; // 정답 문자열
        int count0 = 0;     // 0 개수
        int count1 = 0;     // 1 개수

        // 0과 1의 개수 세기
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count0 += 1;
            }
            else {
                count1 += 1;
            }
        }

        int add0 = 0;   // 추가한 0의 개수
        int add1 = 0;   // 넘긴 1의 개수

        for (int i = 0; i < str.length(); i++) {
            // 추가한 0의 개수가 전체 0 개수의 절반이 될 때까지 추가
            if (str.charAt(i) == '0' && add0 < count0/2) {
                answer += '0';
                add0 += 1;
            }

            if (str.charAt(i) == '1') {
                // 넘긴 1의 개수가 전체 1 개수의 절반이 될 때까지 넘김
                if (add1 < count1/2) {
                    add1 += 1;
                }
                // 절반 넘긴 이후엔 추가
                else {
                    answer += '1';
                }
            }
        }
        System.out.println(answer);
    }
}
