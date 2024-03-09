// 에라토스테네스의 체 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S4_2960 {

    static int n, k;
    static boolean[] visited;
    static int count = 0;
    static boolean ok;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        solution();
    }

    static void solution() {

        for (int i = 2; i <= n; i++) {
            if (ok) {
                return;
            }

            if (!visited[i]) {
                remove(i);
            }
        }
    }

    static void remove(int x) {

        for (int i = x; i <= n; i+=x) {
            if (!visited[i]) {
                visited[i] = true;
                count += 1;
            }
            if (count == k) {
                System.out.println(i);
                ok = true;
                break;
            }
        }
    }
}
