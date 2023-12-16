// 숫자 정사각형 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class S3_1051 {
    static int n,m;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input.charAt(j-1) - '0';
            }
        }

        solution();
    }
    static void solution() {
        int answer = 1;

        for (int length = 0; length <= Math.min(n,m); length++) {   // 정사각형 길이
            for (int i = 1; i <= n - length; i++) {
                for (int j = 1; j <= m - length; j++) {
                    if (arr[i][j] == arr[i+length][j] & arr[i][j] == arr[i][j+length] & arr[i][j] == arr[i+length][j+length]) {
                        answer = length+1;
                    }
                }
            }
        }

        System.out.println(answer*answer);
    }
}
