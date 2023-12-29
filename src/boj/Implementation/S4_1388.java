// 바다 장식 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S4_1388 {
    static int n, m;        // 바닥 크기
    static char[][] arr;    // 바닥 모양
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);

                if(arr[i][j] == '-') {
                    if (j == 0) {   // 가로 시작인 경우
                        answer += 1;
                    }
                    else {
                        if (arr[i][j-1] != '-') {   // 가로 시작인 경우
                            answer += 1;
                        }
                    }
                }
                else {
                    if (i == 0) {   // 세로 시작인 경우
                        answer += 1;
                    }
                    else {
                        if (arr[i-1][j] != '|') {   // 세로 시작인 경우
                            answer += 1;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
