// 양 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S1_3184 {

    static int r, c;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int s, w;
    static int[] answer = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        solution();
    }

    static void solution() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] & !(arr[i][j] == '#')) {
                    bfs(i, j);
                }
            }
        }
        System.out.printf("%d %d", answer[0], answer[1]);
    }

    static void bfs(int x, int y) {
        s = 0;
        w = 0;
        if (arr[x][y] == 'o') {
            s += 1;
        }
        else if (arr[x][y] == 'v') {
            w += 1;
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{x, y});
        while (!dq.isEmpty()) {
            int[] now = dq.pop();
            int nx = now[0];
            int ny = now[1];
            visited[nx][ny] = true;

            for (int i = 0; i < 4; i++) {
                int mx = nx + d[i][0];
                int my = ny + d[i][1];
                if (mx >= 0 & mx < r & my >= 0 & my < c) {
                    if (!visited[mx][my]) {
                        if (arr[mx][my] == 'o') {
                            s += 1;
                            visited[mx][my] = true;
                            dq.add(new int[]{mx, my});
                        }
                        else if (arr[mx][my] == 'v') {
                            w += 1;
                            visited[mx][my] = true;
                            dq.add(new int[]{mx, my});
                        }
                        else if (arr[mx][my] == '.') {
                            visited[mx][my] = true;
                            dq.add(new int[]{mx, my});
                        }
                    }
                }
            }
        }
        if (s > w) {
            answer[0] += s;
        }
        else {
            answer[1] += w;
        }
    }
}
