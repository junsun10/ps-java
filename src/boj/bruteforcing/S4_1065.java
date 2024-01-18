// 한수 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;

public class S4_1065 {
    static int n;   // n 까지의 자연수
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        for (int i = 1; i <= n; i++) {  // 1부터 n까지 자연수가 한수인지 확인
            if (check(i)) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    // x가 한수이면 true, 한수가 아니면 false 반환
    static boolean check(int x) {
        if (x < 10) {   // 한자리 수는 모두 한수
            return true;
        }
        boolean available = true;

        int temp = x;
        int sub = temp/10%10 - temp%10; // 1의 자리 수와 10의 자리 수의 차
        temp /= 10;
        while (temp >= 10) {
            if (temp/10%10 - temp%10 != sub) {
                available = false;
                break;
            }
            temp /= 10;
        }

        return available;
    }
}
