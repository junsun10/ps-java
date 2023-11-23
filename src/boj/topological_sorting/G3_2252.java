// 줄 세우기 ( 정답 )
// 알고리즘: 위상 정렬
// 1. 정점들의 Indegree, Indeg[1...N] 계산하기
// 2. 들어오는 간선이 0개인 (Indeg[i] == 0) 정점들을 찾아서 자료구조 D 에 넣기
// 3. D가 빌 때까지
//    1. D 에서 원소 X를 꺼내서 “정렬”시키기
//    2. Graph 에서 정점 X “제거”하기
//    3. “새롭게 정렬 가능한 점”을 찾아서 D에 넣기

package boj.topological_sorting;

import java.io.*;
import java.util.*;

public class G3_2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;    // n: 학생의 수, m: 키를 비교한 횟수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접 리스트
    static int[] count; // 자신보다 앞에 와야 되는 사람의 수;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        count = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);    // 인접 리스트에 추가
            count[b] += 1;          // 자신보다 앞에 와야 되는 사람 수 증가
        }
    }

    // 위상 정렬
    static void solution() {
        ArrayList<Integer> answer = new ArrayList<>();  // 정답 리스트

        Deque<Integer> dq = new ArrayDeque<>(); // 다음 정렬할 목록
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {    // 자신보다 앞에 와야 되는 사람이 없는 경우
                dq.add(i);
            }
        }

        while (!dq.isEmpty()) {
            int now = dq.pop();
            answer.add(now);

            // now보다 뒤에 와야 되는 사람들
            for (Integer i : graph.get(now)) {
                count[i] -= 1;      // count에서 now 제외
                if (count[i] == 0) {// now 제외하면 count 0인 경우
                    dq.add(i);
                }
            }
        }

        for (Integer i : answer) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
