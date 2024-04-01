// 돌려 돌려 돌림판! ( 정답 )
// 알고리즘: 브루트포스, 시뮬레이션

package boj.simulation;

import java.io.*;
import java.util.*;

public class S5_11504 {

    static int n, m;
    static int x, y;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n+m-1];

            st = new StringTokenizer(br.readLine(), " ");
            x = 0;
            for (int j = 0; j < m; j++) {
                x += Math.pow(10,(m - j - 1)) * Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            y = 0;
            for (int j = 0; j < m; j++) {
                y += Math.pow(10,(m - j - 1)) * Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < m-1; j++) {
                arr[n+j] = arr[j];
            }

            solution();
        }
    }

    static void solution() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += Math.pow(10,(m - j - 1)) * arr[i+j];
            }
            if (temp >= x & temp <= y) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
