// 세탁소 사장 동혁 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;

public class B3_2720 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int money = Integer.parseInt(br.readLine());

            System.out.printf("%d ", money/25);
            money %= 25;
            System.out.printf("%d ", money/10);
            money %= 10;
            System.out.printf("%d ", money/5);
            money %= 5;
            System.out.printf("%d\n", money);
        }
    }
}
