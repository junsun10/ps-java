// ABCDE ( 정답 )
// 알고리즘: dfs, 백트래킹
// 간선을 인접 행렬 저장시 시간초과 발생
// 인접 리스트 사용

package boj.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_13023 {
    public static int n,m;  // n: 사람의 수, m: 친구 관계의 수
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();  // 친구 관계 리스트
    public static boolean[] visited;    // 방문 여부
    public static boolean answer = false;   // 정답 여부

    public static void main(String[] args) throws Exception {
        read();     // 입력 함수
        solution(); // 풀이 함수
        if (answer) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());   // 사람의 수
        m = Integer.parseInt(st.nextToken());   // 친구 관계의 수
        for (int i = 0; i < n; i++) {           // 리스트 초기화
            arr.add(new ArrayList<>());
        }
        visited = new boolean[n];               // 방문 배열 초기화
        for (int i = 0; i < m; i++) {           // 친구 관계 저장
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
    }

    // 풀이 함수
    public static void solution() {
        // 각 친구에서 dfs 진행
        for (int i = 0; i < n; i++) {
            if (answer) {
                break;
            }
            visited[i] = true;  // 방문 처리 후 dfs
            dfs(i, 1);
            visited[i] = false; // 종료 후 초기화
        }
    }

    public static void dfs(int start, int count) {
        // 이미 정답이 존재하면 리턴
        if (answer) {
            return;
        }
        // 조건을 만족하면 정답처리 후 리턴
        if (count == 5) {
            answer = true;
            return;
        }
        // 현재 정점과 연결된 정점들의 리스트 가져오기
        ArrayList<Integer> now = arr.get(start);
        for (int to : now) {
            // 방문하지 않은 노드이면 추가
            if (!visited[to]) {
                visited[to] = true;
                dfs(to, count+1);
                visited[to] = false;
            }
        }
    }
}
