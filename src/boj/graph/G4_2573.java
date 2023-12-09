// 빙산 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class G4_2573 {
    static int n, m;    // 지도 크기
    static int[][] map; // 지도 정보
    static Deque<int[]> bing = new ArrayDeque<>();  // 빙산 좌표 배열

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int p = Integer.parseInt(st.nextToken());
                map[i][j] = p;
                if (p > 0) {    // 빙산 좌표 저장
                    bing.add(new int[] {i,j});
                }
            }
        }

        solution();
    }

    static void solution() {
        int answer = 0;     // 정답
        while (true) {
            melt();             // 빙산 상태 변환 함수
            int c = check();    // 빙산 상태 확인 함수
            if (c == 0) {       // 빙산이 나뉘지 않고 모두 없어진 경우
                answer = 0;
                break;
            }
            else if (c == -1) { // 빙산이 나뉜 경우
                answer += 1;
                break;
            }
            else {              // 빙산이 나뉘지 않은 경우
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    // 주변 바다 개수에 따라 빙산 녹이는 함수
    static void melt() {
        int[][] newMap = new int[n][m];     // 새로운 지도 상태 저장 배열
        int count = bing.size();            // 현재 빙산 좌표 개수 저장
        for (int i = 0; i < count; i++) {   // 전체 빙산 녹이기
            int[] temp = bing.remove();     // 빙산 좌표
            int x = temp[0];
            int y = temp[1];
            int water = 0;                  // 주변 바다 개수
            // 상하좌우 바다 확인
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx >= 0 & nx < n & ny >= 0 & ny < m) {
                    if (map[nx][ny] == 0) {
                        water += 1;
                    }
                }
            }
            newMap[x][y] = Math.max(0, map[x][y] - water);  // 빙산은 0보다 작아질 수 없음
            if (newMap[x][y] > 0) {         // 아직 빙산인 경우 빙산 목록에 저장
                bing.add(new int[]{x, y});
            }
        }
        for (int i = 0; i < n; i++) {       // 새로운 지도 상태 복사
            map[i] = newMap[i].clone();
        }
    }

    // 빙산이 다 녹았는지, 두개 이상으로 분리됐는지 확인하는 함수
    static int check() {
        if (bing.isEmpty()) {   // 빙산이 모두 녹은 경우
            return 0;
        }
        int count = bing.size();        // 빙산 좌표 개수 저장

        int[] temp = bing.getFirst();   // 첫번째 빙산 좌표 기준으로 bfs 진행
        if (bfs(temp[0], temp[1]) == count) {   // bfs로 방문한 개수가 전체 빙산 좌표 개수랑 같으면
            return 1;                           // 나눠지지 않은 상태이므로 1 리턴
        }
        else {                                  // 개수가 모자라면 나뉘어진 것
            return -1;
        }

    }

    static int bfs(int a, int b) {
        int count = 0;  // 방문한 빙산 좌표 수 저장
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        dq.add(new int[] {a,b});
        visited[a][b] = true;
        count += 1;
        while (!dq.isEmpty()) {
            int[] temp = dq.remove();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 & nx < n & ny >= 0 & ny < m) {
                    if (map[nx][ny] > 0 & !visited[nx][ny]) { // 방문하지 않은 빙산 좌표 추가
                        dq.add(new int[]{nx,ny});
                        count += 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return count;   // 방문한 좌표 수 리턴
    }
}
