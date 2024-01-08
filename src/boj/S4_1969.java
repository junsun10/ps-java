// DNA ( 정답 )
// 알고리즘: 문자열, 그리, 브루트포스

package boj;

import java.io.*;
import java.util.*;

public class S4_1969 {
    static int n, m;
    static String[] arr;    // 입력 문자열
    static Node[] nodes;    // 알파벳 A ~ z

    static class Node {
        char name;
        int count;

        public Node(char name, int count) {
            this.name = name;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n];
        nodes = new Node[26];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solution();
    }

    // 알파벳 count 초기화
    static void setNodes() {
        for (int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            nodes[i] = new Node(c,0);
        }
    }

    static void solution() {
        String answer = "";
        int count = 0;

        for (int i = 0; i < m; i++) {   // 각 위치별 알파벳 개수 세기
            setNodes();
            for (int j = 0; j < n; j++) {
                char temp = arr[j].charAt(i);
                for (int k = 0; k < 26; k++) {
                    if (nodes[k].name == temp) {
                        nodes[k].count += 1;
                    }
                }
            }
            Arrays.sort(nodes, new Comparator<Node>() {     // 개수가 많은 순, 같으면 사전 순 정렬
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.count == o2.count) {
                        return o1.name - o2.name;
                    }
                    else {
                        return o2.count - o1.count;
                    }
                }
            });
            answer += nodes[0].name;    // 정렬된 첫번째 알파벳 선택
        }

        for (int i = 0; i < n; i++) {   // 정답 개수 세기
            if (arr[i].equals(answer)) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (answer.charAt(j) != arr[i].charAt(j)) {
                    count += 1;
                }
            }
        }
        System.out.println(answer);
        System.out.println(count);
    }
}
