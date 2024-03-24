// 숫자 게임 ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S5_2303 {

    static int n;
    static int[][] arr;
    static int[] picked;
    static int maxVal = 0;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];
        picked = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            dfs(i, 0, 0);
        }
        System.out.println(answer+1);
    }

    static void dfs(int num, int index, int count) {

        if (count == 3) {
            int val = 0;
            for (int i = 0; i < 3; i++) {
                val += picked[i];
            }
            val %= 10;

            if (val >= maxVal) {
                maxVal = val;
                answer = num;
            }
            return;
        }

        for (int i = index; i < 5; i++) {
            picked[count] = arr[num][i];
            dfs(num, i + 1, count + 1);
        }
    }
}
