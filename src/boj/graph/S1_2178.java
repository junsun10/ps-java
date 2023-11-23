// 미로 탐색 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S1_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
    }

    // bfs
    static void solution() {
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited = new boolean[n][m];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0,1});   // dq에 count 정보도 추가
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            int[] pop = dq.pop();
            int x = pop[0], y = pop[1], c = pop[2];

            // 목표 지점 도달시 종료
            if (x == n-1 & y == m-1) {
                System.out.println(c);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+d[i][0], ny = y+d[i][1];
                if (nx >= 0 & nx < n & ny >= 0 & ny < m) {
                    if (!visited[nx][ny] & arr[nx].charAt(ny) == '1') {
                        dq.add(new int[]{nx,ny,c+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
