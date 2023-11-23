// 트리의 부모 찾기 ( 정답 )
// 알고리즘: 트리, bfs

package boj.tree;

import java.io.*;
import java.util.*;

public class S2_11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();  // 인접 리스트

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n+1; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 정보 인접 리스트에 저장
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }
    }

    static void solution() throws Exception {
        int[] answer = new int[n+1];            // 각 노드의 부모 노드 저장
        boolean[] visited = new boolean[n+1];   // 노드 방문 여부 확인

        // 루트 노드인 1에서 bfs 시작
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        visited[1] = true;

        while (!dq.isEmpty()) {
            int p = dq.pop();
            for (int i = 0; i < tree.get(p).size(); i++) {
                int c = tree.get(p).get(i);
                if (visited[c]) {
                    continue;
                }
                answer[c] = p;
                dq.add(c);
                visited[c] = true;
            }
        }

        // 각 노드의 부모 노드를 순서대로 출력
        for (int i = 2; i <= n; i++) {
            bw.write(answer[i]+"\n");
        }
        bw.flush();
    }
}
