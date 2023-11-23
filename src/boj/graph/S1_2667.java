// 단지번호붙이기 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class S1_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] =  Integer.parseInt(Character.toString(input.charAt(j)));
            }
        }
    }

    static void solution() {
        ArrayList<Integer> answer = new ArrayList<>();  // 단지 목록
        boolean[][] visited = new boolean[n][n];        // 방문 처리

        // 연결된 집 계산 위한 배열
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        // 모든 위치에 대해 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 위치가 집이고 미방문이면 bfs 진행
                if (arr[i][j] == 1 & !visited[i][j]) {
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.add(new int[]{i,j});
                    visited[i][j] = true;
                    int count = 1;      // 단지 크기 계산

                    while (!dq.isEmpty()) {
                        int[] d = dq.pop();
                        int x = d[0];
                        int y = d[1];
                        // 연결된 집 방문
                        for (int k = 0; k < 4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if (nx >=0 & nx < n & ny >= 0 & ny < n) {
                                if (arr[nx][ny] == 1 & !visited[nx][ny]) {
                                    dq.add(new int[]{nx,ny});
                                    visited[nx][ny] = true;
                                    count += 1;
                                }
                            }
                        }
                    }
                    answer.add(count);  // 단지 크기 저장
                }
            }
        }
        System.out.println(answer.size());  // 단지 개수 출력
        Collections.sort(answer);           // 단지 목록 오름차순 정렬 뒤 출력
        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
