// 숫자고르기 ( 정답 )
// 알고리즘: dfs

package boj.graph;

import java.io.*;

public class G5_2668 {
    public static int n;        // 숫자 범위
    public static int[][] arr;  // 입력 배열

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][2];

        for (int i = 1; i < n+1; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(br.readLine());
        }
    }

    // 풀이 함수
    public static void solution() throws Exception {
        boolean[][] visited = new boolean[n+1][2];  // 방문 정보 저장

        // 1부터 n까지 방문
        for (int i = 1; i < n+1; i++) {
            // visited 복제
            boolean[][] temp = new boolean[n+1][2];
            for (int j = 0; j < n+1; j++) {
                temp[i][0] = visited[i][0];
                temp[i][1] = visited[i][1];
            }
            // i를 방문하지 않은 경우 dfs 진행
            if (!temp[i][0]) {
                temp = dfs(i, temp);
                // check를 통해 사이클이 생성됐는지 확인
                if (check(temp)) {
                    // 사이클이 생성됐으면 visited에 복제
                    for (int j = 0; j < n + 1; j++) {
                        visited[i][0] = temp[i][0];
                        visited[i][1] = temp[i][1];
                    }
                }
            }
        }

        int count = 0;  // 정답값
        // 1부터 n까지 순회
        for (int i = 1; i < n+1; i++) {
            // 방문한 경우 정답에 저장
            if (visited[i][0]) {
                count += 1;
                bw.write(i+"\n");
            }
        }
        System.out.println(count);  // 정답값 출력
        bw.flush(); // 선택된 값들 출력
    }

    // dfs
    public static boolean[][] dfs(int i, boolean[][] temp) {
        temp[i][0] = true;          // i 방문 처리
        temp[arr[i][1]][1] = true;  // i 위치에 대응되는 두번째줄 값 방문 처리
        if (!temp[arr[i][1]][0]) {  // i 위치에 대응되는 두번째줄 값이 첫째줄 기준 미방문인 경우 dfs 진행
            temp = dfs(arr[i][1], temp);
        }
        return temp;    // 방문 정보 리턴
    }

    // 사이클이 생성됐는지 확인
    public static boolean check(boolean[][] visited) {
        for (int i = 1; i < n+1; i++) {
            // 두 값이 다른 경우 사이클이 아님
            if (visited[i][0] != visited[i][1]) {
                return false;
            }
        }
        return true;
    }
}
