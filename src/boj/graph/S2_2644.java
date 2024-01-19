// 촌수계산 ( 정답 )
// 알고리즘: dfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S2_2644 {
    static int n, m;        // n: 전체 사람의 수, m: 부모 자식 관계의 수
    static int from, to;    // 촌수를 찾을 사람
    static int[][] arr;     // 부모 자식 관계
    static boolean[] visited;   // dfs 방문 여부
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        solution();
    }

    static void solution() {
        dfs(from, 0);
        System.out.println(answer);
    }

    static void dfs(int index, int count) {
        visited[index] = true;
        for (int i = 1; i <= n; i++) {
            if (i == to & arr[index][i] == 1) { // from과 to가 연결 된 경우
                answer = count + 1;
                return;
            }

            if (!visited[i] & arr[index][i] == 1) { // index와 i가 연결 된 경우
                visited[i] = true;
                dfs(i, count+1);
            }
        }
    }
}
