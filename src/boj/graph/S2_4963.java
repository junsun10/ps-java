// 섬의 개수 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S2_4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");   // 너비, 높이 입력

            int w = Integer.parseInt(st.nextToken());   // 너비
            int h = Integer.parseInt(st.nextToken());   // 높이

            if (w == 0 && h == 0) { // 종료 조건
                break;
            }

            int[][] arr = new int[h][w];    // 지도

            for (int i = 0; i < h; i++) {   // 지도 할당
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0; // 섬의 개수
            boolean[][] visited = new boolean[h][w];    // 방문 여부 확인 배열

            // 지도 전체 탐색
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 방문하지 않은 위치이고 땅인 경우 bfs 진행
                    if (!visited[i][j] && arr[i][j] == 1) {
                        answer += 1;
                        visited = bfs(i,j,arr,visited,w,h); // bfs 함수를 통해 visted 배열 갱신
                    }
                }
            }
            System.out.println(answer);
        }
    }

    // 입력된 위치에서 너비우선 탐색을 통해 방문한 위치정보 배열 리턴
    static boolean[][] bfs(int idxX, int idxY, int[][] arr, boolean[][] visited, int w, int h) {
        int[][] d = {{-1,-1,0,1,1,1,0,-1}, {0,1,1,1,0,-1,-1,-1}}; // 북쪽부터 시계방향

        Deque<int[]> dq = new ArrayDeque<>();
        int[] temp = {idxX,idxY};
        dq.add(temp);
        visited[idxX][idxY] = true;

        // dq가 빌때까지
        while (dq.size() > 0) {
            temp = dq.removeFirst();
            int x = temp[0];
            int y = temp[1];

            // 8개 방향 방문
            for (int i = 0; i < 8; i++) {
                int nx = x + d[0][i];
                int ny = y + d[1][i];

                // 지도 범위 내, 미방문 위치인지 확인
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    // 땅인 경우 dq에 추가
                    if (arr[nx][ny] == 1) {
                        int[] next = {nx, ny};
                        dq.addLast(next);
                    }
                }
            }
        }
        return visited; // 갱신된 방문 위치정보 배열 리턴
    }
}
