// 카드 놓기 ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S4_5568 {

    static int n, k;
    static String[] arr;
    static ArrayList<String> answers = new ArrayList<>();
    static String[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        selected = new String[k];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solution();
    }

    static void solution() {

        dfs(0);
        System.out.println(answers.size());
    }

    static void dfs(int c) {
        if (c == k) {
            String temp = "";
            for (String s : selected) {
                temp += s;
            }
            if (!answers.contains(temp)) {
                answers.add(temp);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                selected[c] = arr[i];
                visited[i] = true;
                dfs(c + 1);
                visited[i] = false;
            }
        }
    }
}
