// 비밀 편지 ( 정답 )
// 알고리즘: 문자열

package boj.string;

import java.io.*;

public class S5_5426 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            int len = input.length();
            int n = (int)Math.sqrt(len);

            for (int j = n-1; j >= 0; j--) {
                for (int k = j; k < len; k=k+n) {
                    bw.write(input.charAt(k));
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
