// DFS와 BFS ( 정답 )
// 알고리즘: dfs, bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S2_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, v;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x,y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
    }

    static void solution() {
        // dfs
        boolean[] visited = new boolean[n+1];
        dfs(v, visited);
        System.out.println();

        // bfs
        bfs();
    }

    static void dfs(int x, boolean[] visited) {
        visited[x] = true;
        System.out.printf("%d ", x);
        for (int i = 1; i <= n; i++) {
            if (arr[x][i] == 1 & !visited[i]) {     // 연결된 노드가 미방문이면 추가
                dfs(i, visited);
            }
        }
    }

    static void bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(v);
        boolean[] visited = new boolean[n+1];
        visited[v] = true;
        System.out.printf("%d ", v);

        while (!dq.isEmpty()) {
            int x = dq.pop();
            for (int i = 1; i <= n; i++) {
                if (arr[x][i] == 1 & !visited[i]) {     // 연결된 노드가 미방문이면 추가
                    dq.add(i);
                    visited[i] = true;
                    System.out.printf("%d ", i);
                }
            }
        }
        System.out.println();
    }
}
