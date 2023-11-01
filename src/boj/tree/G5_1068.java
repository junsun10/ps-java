// 트리 ( 정답 )
// 알고리즘: 트리, dfs
// 트리를 구현하고 dfs로 리프 노드의 개수를 계산

package boj.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_1068 {
    public static int n;            // 노드의 개수
    public static int[] input;      // 입력값 저장 배열
    public static int removeNode;   // 삭제할 노드
    public static int answer = 0;   // 정답
    public static ArrayList<Node> arr = new ArrayList<>();  // 전체 노드 리스트

    // 노드 클래스
    public static class Node {
        int value;      // 노드 번호
        Node parents;   // 부모 노드
        ArrayList<Node> child = new ArrayList<>();  // 지식 노드 리스트

        Node(int value) {
            this.value = value;
            this.parents = null;
        }
    }

    public static void main(String[] args) throws Exception {
        read();     // 입력 함수
        solution(); // 풀이 함수
        System.out.println(answer);
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 노드의 개수

        input = new int[n];     // 입력값 저장할 배열 초기화
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        removeNode = Integer.parseInt(br.readLine());   // 삭제할 노드 저장
    }

    // 풀이 함수
    public static void solution() {
        // 노드 생성
        for (int i = 0; i < n; i++) {
            arr.add(new Node(i));
        }

        int root = 0;   // 루트 노드 번호를 저장할 변수

        for (int i = 0; i < n; i++) {
            // 루트 노드인 경우
            if (input[i] == -1) {
                root = i;
            }
            else {
                int now = i;                // 현재 노드 번호
                int parents = input[i];     // 부모 노드 번호
                arr.get(now).parents = arr.get(parents);    // 현재 노드의 부모 노드 할당
                arr.get(parents).child.add(arr.get(now));   // 부모 노드에 현재 노드를 자식에 추가
            }
        }

        // 루트 노드가 삭제할 노드인 경우 정답은 0
        if (root == removeNode) {
            answer = 0;
        }
        else {
            Node rootNode = arr.get(root);   // 루트 노드
            dfs(rootNode);                   // 루트 노드부터 dfs를 통해 리프 노드의 개수 계산
        }
    }

    // dfs를 통해 리프 노드 개수를 계산하는 함수
    public static void dfs(Node node) {
        // 자식이 없으면 리프 노드
        if (node.child.size() == 0) {
            answer += 1;
        }
        else {
            for (int i = 0; i < node.child.size(); i++) {
                // 자식에 삭제할 노드가 있는 경우
                if (node.child.get(i).value == removeNode) {
                    // 자식이 하나였으면 리프 노드가 되므로 정답 증가
                    if (node.child.size() == 1) {
                        answer += 1;
                    }
                }
                else {
                    dfs(node.child.get(i)); // 자식 노드로 dfs 진행
                }
            }
        }
    }
}
