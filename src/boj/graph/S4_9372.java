// 상근이의 여행 ( 정답 )
// 알고리즘: bfs
// 그래프에서 n개의 노드가 모두 연결되기 위해
// 최소 n-1개의 간선이 필요함
// 단순히 n-1도 정답

package boj.graph;

import java.io.*;
import java.util.*;

public class S4_9372 {
    static int t;
    static int n, m;    // n: 노드 수, m: 간선 수
    static int[][] arr; // 간선 정보
    static Deque<Integer> dq = new ArrayDeque<>();
    static boolean[] visited;
    static int answer;
    static int start;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n+1][n+1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
                arr[y][x] = 1;
                if (i == 0) {
                    start = x;
                }
            }

            solution();
            System.out.println(answer);
        }
    }

    // 모든 정점을 방문하도록 bfs
    static void solution() {
        answer = 0;
        visited = new boolean[n + 1];
        dq.clear();
        dq.add(start);
        visited[start] = true;

        while (!dq.isEmpty()) {
            int from = dq.pop();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] & arr[from][i] == 1) {
                    dq.add(i);
                    visited[i] = true;
                    answer += 1;
                }
            }
        }
    }
}
