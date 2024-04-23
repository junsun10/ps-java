// 거스름돈 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;

public class B2_5585 {

    static int n;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        int money = 1000 - n;

        answer += money / 500;
        money %= 500;

        answer += money / 100;
        money %= 100;

        answer += money / 50;
        money %= 50;

        answer += money / 10;
        money %= 10;

        answer += money / 5;
        money %= 5;

        answer += money;

        System.out.println(answer);
    }
}
