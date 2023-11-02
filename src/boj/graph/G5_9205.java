// 맥주 마시면서 걸어가기 ( 정답 )
// 알고리즘: bfs
// bfs를 통해 집에서 페스티벌까지 도달할 수 있는지 확인

package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Deque;

public class G5_9205 {
    public static int t;    // 테스트 케이스 수
    public static int n;    // 편의점 개수
    public static int[] house = new int[2];  // 상근이네 집 좌표
    public static int[][] arr;  // 편의접 좌표 저장 배열
    public static int[] goal = new int[2];   // 페스티벌 좌표

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        read(0);    // 테스트 케이스 수 입력
        for (int i = 0; i < t; i++) {
            read(1);    // 문제 정보 입력
            solution();    // 풀이 함수
        }
    }

    // 문제 입력
    public static void read(int x) throws Exception {
        // 테스트 케이스 수 입력
        if (x == 0) {
            t = Integer.parseInt(br.readLine());
        }
        // 문제 정보 입력
        else {
            n = Integer.parseInt(br.readLine());            // 편의점 수

            st = new StringTokenizer(br.readLine()," ");
            // 집 좌표 저장
            house[0] = Integer.parseInt(st.nextToken());
            house[1] = Integer.parseInt(st.nextToken());

            arr = new int[n][2];    // 편의점 좌표 저장 배열 초기화
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine()," ");
                // 편의점 좌표 저장
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()," ");
            // 페스티벌 좌표 저장
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());
        }
    }

    // 풀이 함수
    // bfs 함수의 리턴값으로 페스티벌 도착 가능 여부를 받아 정답 출력
    public static void solution() {
        boolean isHappy = bfs();    // 페스티벌 도착 가능 여부
        if (isHappy) {
            System.out.println("happy");
        }
        else {
            System.out.println("sad");
        }
    }

    // bfs 함수
    // 집에서 페스티벌까지 도달할 수 있는지 bfs를 통해 확인
    public static boolean bfs() {
        boolean isHappy = false;        // 페스티벌 도착 가능 여부

        Deque<int[]> dq = new ArrayDeque<>();   // 도달 가능한 편의점 저장
        int[] tmp = {house[0], house[1]};       // 집에서 출발
        dq.add(tmp);
        boolean[] visited = new boolean[n];     // 편의점 방문 여부 저장 배열

        // bfs 진행
        while (dq.size() > 0) {
            int[] temp;
            temp = dq.removeFirst();
            // 현재 좌표 저장
            int x = temp[0];
            int y = temp[1];

            // 현재 위치에서 페스티벌 도달 가능 여부 확인
            int toGoal =  Math.max(x, goal[0]) - Math.min(x, goal[0]) + Math.max(y, goal[1]) - Math.min(y, goal[1]);
            if (toGoal <= 20*50) {
                isHappy = true;
                break;
            }

            // 편의점 목록 순회
            for (int i = 0; i < n; i++) {
                int to_x = arr[i][0];
                int to_y = arr[i][1];
                // 현재 위치에서 해당 편의점까지 거리
                int distance = Math.max(x, to_x) - Math.min(x, to_x) + Math.max(y, to_y) - Math.min(y, to_y);

                // 현재 위치에서 해당 편의점까지 도달 가능하고, 방문한 적 없는 편의점인 경우 dq에 추가
                if (distance <= 20*50 && ! visited[i]) {
                    int[] add = {to_x, to_y};
                    visited[i] = true;
                    dq.add(add);
                }
            }
        }

        return isHappy;     // 페스티벌 도착 가능 여부 리턴
    }
}
