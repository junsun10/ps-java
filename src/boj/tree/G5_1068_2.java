// 트리 ( 정답 )
// 알고리즘: 트리, dfs

package boj.tree;

import java.io.*;
import java.util.*;

public class G5_1068_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;    // n: 노드 개수, m: 지울 노드
    static int root;    // 루트 노드 번호
    static Node[] nodes;// 노드 목록
    static int answer;  // 리프 노드의 개수

    static class Node {
        int value;  // 노드 번호
        ArrayList<Node> child = new ArrayList<>();  // 자식 노드 리스트

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        n = Integer.parseInt(br.readLine());

        // 노드 목록 생성
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        // 자식 노드 정보 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) {
                nodes[p].child.add(nodes[i]);
            }
            else {  // 루트 노드
                root = i;
            }
        }
        m = Integer.parseInt(br.readLine());    // 지울 노드
    }

    static void solution() {
        if (root == m) {    // 지울 노드가 루트이면
            System.out.println(0);
        }
        else {
            dfs(nodes[root]);   // 루트 노드에서 dfs
            System.out.println(answer);
        }
    }

    static void dfs(Node p) {
        // 자식이 없으면 리프 노드
        if (p.child.size() == 0) {
            answer += 1;
        }
        else {
            // 자식이 하나인데 그 노드가 지울 노드이면 현재 노드는 리프 노드
            if (p.child.size() == 1 & p.child.get(0).value == m) {
                answer += 1;
            }
            else {
                for (int i = 0; i < p.child.size(); i++) {
                    Node c = p.child.get(i);
                    if (c.value == m) { // 지울 노드이면 통과
                        continue;
                    }
                    dfs(c); // 자식 노드로 dfs
                }
            }
        }
    }
}
