// 탈출 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class G4_3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C;    // R: 행, C: 열
    static int[] from;  // 시작 좌표
    static Deque<int[]> water = new ArrayDeque<>(); // 다음 시간에 확장되어야 하는 물 좌표
    static char[][] arr;        // 숲 상태
    static boolean[][] visited; // 고슴도치 방문 확인
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        // 숲 상태 입력
        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++) {
                arr[i][j] = input.charAt(j);

                if (arr[i][j] == 'S') {         // 시작 위치
                    from = new int[]{i,j};
                }
                else if (arr[i][j] == '*') {    // 물 위치
                    water.add(new int[]{i,j});
                }
            }
        }
    }

    static void solution() {
        int answer = R*C;
        moveWater();    // 다음 시간에 물에 잠길 예정인 곳은 갈 수 없으므로 먼저 물 확장

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{from[0],from[1],0});
        visited[from[0]][from[1]] = true;
        int time = 0;    // 현재 시간 확인

        while (!dq.isEmpty()) {
            int[] pop = dq.pop();
            int x = pop[0], y = pop[1], t = pop[2];

            // 다음 시간으로 넘어가면 물 확장
            if (t > time) {
                moveWater();
                time += 1;
            }

            // 인접한 칸 방문
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if (nx >= 0 & nx < R & ny >= 0 & ny < C) {
                    if (visited[nx][ny]) {
                        continue;
                    }

                    // 비버 굴 도착
                    if (arr[nx][ny] == 'D') {
                        answer = Math.min(t+1, answer);
                    }
                    // 이동 가능한 위치
                    else if (arr[nx][ny] == '.') {
                        dq.add(new int[]{nx,ny,t+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if (answer == R*C) {        // 비버의 굴로 이동할 수 없음
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(answer);
        }
    }

    // 물을 확장하는 함수
    static void moveWater() {
        int size = water.size();    // 확장해야하는 지점 개수 저장
        for (int i = 0; i < size; i++) {
            int[] pop = water.pop();
            int x = pop[0], y = pop[1];

            // 인접 칸 확인
            for (int j = 0; j < 4; j++) {
                int nx = x+dx[j], ny = y+dy[j];
                if (nx >= 0 & nx < R & ny >= 0 & ny < C) {
                    if (arr[nx][ny] == '.') {           // 비어있는 곳이면 확장
                        arr[nx][ny] = '*';
                        water.add(new int[]{nx,ny});    // 다음 시간에 확장해야 하므로 좌표 저장
                    }
                }
            }
        }
    }
}
