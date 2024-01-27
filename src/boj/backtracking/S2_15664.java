// N 과 M (10) ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S2_15664 {

    static int n, m;
    static int[] arr;
    static int[] answer;
    static ArrayList<int[]> answers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        dfs(0, 0);
    }

    static void dfs(int x, int c) {
        if (c == m) {
            if(!visited()) {
                answers.add(answer.clone());
                for (int i : answer) {
                    System.out.printf("%d ", i);
                }
                System.out.println();
            }
            return;
        }

        for (int i = x; i < n; i++) {
            answer[c] = arr[i];
            dfs(i+1, c+1);
        }
    }

    static boolean visited() {
        boolean v = false;
        for (int[] ints : answers) {
            if (Arrays.equals(ints, answer)) {
                v = true;
                break;
            }
        }
        return v;
    }
}
