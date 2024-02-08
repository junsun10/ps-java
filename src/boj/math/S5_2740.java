// 행렬 곱셈 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S5_2740 {
    static int n, m, k;
    static int[][] arr1;
    static int[][] arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        k = Integer.parseInt(st.nextToken());
        arr2 = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < k; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.printf("%d ", cal(i,j));
            }
            System.out.println();
        }
    }

    static int cal(int x, int y) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr1[x][i] * arr2[i][y];
        }
        return sum;
    }
}
