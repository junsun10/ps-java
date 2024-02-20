// 직사각형 네개의 합집합의 면적 구하기 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S5_2669 {
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            int x1, y1, x2, y2;
            st = new StringTokenizer(br.readLine(), " ");

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    arr[j][k] += 1;
                }
            }
        }
        int answer = 0;
        for (int j = 1; j < 101; j++) {
            for (int k = 1; k < 101; k++) {
                if (arr[j][k] != 0) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);


    }
}
