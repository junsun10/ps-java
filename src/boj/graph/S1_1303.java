// 전쟁 - 전투 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S1_1303 {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static long[] answer = new long[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'W') {
                    arr[i][j] = 0;
                }
                else {
                    arr[i][j] = 1;
                }
            }
        }

        solution();
    }

    static void solution() {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i,j);
                }
            }
        }

        System.out.printf("%d %d\n", answer[0], answer[1]);
    }

    static void bfs(int x, int y) {

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int type = arr[x][y];
        int count = 1;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {x,y});
        visited[x][y] = true;

        while (!dq.isEmpty()) {
            int[] temp = dq.pop();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 & nx < m & ny >= 0 & ny < n) {
                    if (!visited[nx][ny] & arr[nx][ny] == type) {
                        visited[nx][ny] = true;
                        dq.add(new int[]{nx, ny});
                        count += 1;
                    }
                }
            }
        }

        answer[type] += count*count;
    }
}
