// 순열 사이클 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S3_10451 {
    static int t, n;
    static int[][] arr;
    static boolean[] visited;
    static int answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solution();
        }
    }

    static void solution() throws Exception {
        answer = 0;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i][x] = 1;
            arr[x][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        System.out.println(answer);
    }

    static void bfs(int start) {
        int count = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        dq.add(start);
        while (!dq.isEmpty()) {
            int now = dq.pop();
            visited[now] = true;

            for (int i = 1; i <= n; i++) {
                // 사이클인 경우 확인
                if (i == start & arr[now][i] == 1) {
                    count += 1;
                }
                if (!visited[i] & arr[now][i] == 1) {
                    dq.add(i);
                }
            }
        }
        if (count >= 1) {
            answer += 1;
        }
    }
}
