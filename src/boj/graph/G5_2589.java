// 보물섬 ( 정답 )
// 알고리즘: 브루트포스, bfs
// 브루트포스로 모든 지도 내 육지에서 bfs 진행
// bfs로 시작 지점에서 가장 긴 거리를 구함
// 모든 bfs 결과 중 가장 긴 거리가 정답

package boj.graph;

import java.io.*;
import java.util.*;

public class G5_2589 {
    public static int h, w;     // h: 지도의 높이, w: 지도의 길이
    public static int[][] arr;  // 지도의 상태 (0: 바다, 1: 육지)

    public static void main(String[] args) throws Exception {
        // 문제 입력 및 풀이 함수 호출
        read();
        System.out.println(solution());
    }

    // 문제 입력
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[h][w];    // 지도 초기화

        for (int i = 0; i < h; i++) {
            String temp = br.readLine();
            for (int j = 0; j < w; j++) {
                // L(육지)일 경우에만 1로 변경
                if (temp.charAt(j) == 'L') {
                    arr[i][j] = 1;
                }
            }
        }
    }

    // 풀이 함수
    public static int solution() {
        int answer = 0; // 최대 길이 저장
        // 브루트포스로 모든 위치에서 bfs 진행
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 육지인 경우에만 시작 가능
                if (arr[i][j] == 1) {
                    // bfs 함수의 리턴값인 최대 길이를 기존 정답과 비교
                    answer = Math.max(bfs(i,j), answer);
                }
            }
        }
        return answer;
    }

    public static int bfs(int i, int j) {

        // 좌표 이동 (상, 하, 좌, 우)
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int maxValue = 0;                           // 최대 길이 저장
        boolean[][] visited = new boolean[h][w];    // 방문 확인
        visited[i][j] = true;                       // 시작 지점 방문 처리
        Deque<ArrayList<Integer>> dq = new ArrayDeque<>();  // Deque 초기화
        ArrayList<Integer> start = new ArrayList<>();
        start.add(i);
        start.add(j);
        start.add(0);
        dq.add(start);

        // bfs 진행
        while (dq.size() > 0) {
            ArrayList<Integer> temp = dq.removeFirst();

            // 상,하,좌,우 방문
            for (int k = 0; k < 4; k++) {
                // 좌표 할당
                int nx = temp.get(0) + dx[k];
                int ny = temp.get(1) + dy[k];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {   // 지도 범위 확인
                    if (!visited[nx][ny] && arr[nx][ny] == 1) { // 미방문 상태, 육지 확인
                        ArrayList<Integer> next = new ArrayList<>();
                        next.add(nx);
                        next.add(ny);
                        next.add(temp.get(2)+1);    // 거리 증가
                        dq.add(next);
                        visited[nx][ny] = true;     // 방문 처리

                        maxValue = Math.max(temp.get(2)+1, maxValue);   // 최댓값 비교
                    }
                }
            }
        }
        return maxValue;    // 최댓값 반환
    }
}
