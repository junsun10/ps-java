// 결혼식 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S2_5567 {
    static int n, m;    // n: 동기 수, m: 친구 관계 수
    static int[][] arr; // 인접 행렬
    static boolean[] visited;   // 방문 여부
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        solution();
    }

    static void solution() {
        bfs(1);
        System.out.println(answer);
    }

    static void bfs(int x) {
        Deque<int[]> dq = new ArrayDeque<>();
        visited[x] = true;
        dq.add(new int[]{1, 0});

        while (!dq.isEmpty()) {
            int[] temp = dq.pop();
            int now = temp[0];
            int count = temp[1];

            if (count == 2) {
                continue;
            }
            else {
                for (int i = 1; i <= n; i++) {
                    if (arr[now][i] == 1 & !visited[i]) {
                        dq.add(new int[]{i, count + 1});
                        visited[i] = true;
                        answer += 1;
                    }
                }
            }
        }
    }
}
