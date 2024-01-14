// 부분수열의 합 ( 정답 )
// 알고리즘: 브루트포스, 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S2_1182 {
    static int n, s;    // n: 정수의 개수, s: 합
    static int[] arr;   // 정수 목록
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(answer);
    }

    // 백트래킹
    static void dfs(int index, int sum) {
        if (index != 0 & sum == s) {    // 합이 s와 같으면 정답 증가
            answer += 1;                // 0을 고려해서 return하지 않음
        }
        if (index == n) {   // 마지막까지 도달한 경우
            return;
        }
        for (int i = index; i < n; i++) {
            dfs(i + 1, sum + arr[i]);
        }
    }
}
