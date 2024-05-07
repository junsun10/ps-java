// 영수증 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;

public class B3_5565 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            answer -= Integer.parseInt(br.readLine());
        }

        System.out.println(answer);
    }
}
