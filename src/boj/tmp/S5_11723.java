// 집합 ( 정답 )
// 알고리즘: 구현, 비트마스킹
// 아래 풀이는 배열을 사용함

package boj.tmp;

import java.io.*;
import java.util.*;

public class S5_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        Boolean[] contain = new Boolean[21];
        for (int i = 0; i < 21; i++) {
            contain[i] = false;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String s = st.nextToken();

            if (s.equals("all") || s.equals("empty")) {
                switch (s) {
                    case "all":
                        for (int j = 1; j < 21; j++) {
                            contain[j] = true;
                        }
                        break;

                    case "empty":
                        for (int j = 1; j < 21; j++) {
                            contain[j] = false;
                        }
                        break;
                }
            }
            else {
                int x = Integer.parseInt(st.nextToken());

                switch (s) {
                    case "add":
                        contain[x] = true;
                        break;

                    case "remove":
                        contain[x] = false;
                        break;

                    case "check":
                        if (contain[x]) {
                            bw.write("1\n");
                        }
                        else {
                            bw.write("0\n");
                        }
                        break;

                    case "toggle":
                        if (contain[x]) {
                            contain[x] = false;
                        }
                        else {
                            contain[x] = true;
                        }
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
