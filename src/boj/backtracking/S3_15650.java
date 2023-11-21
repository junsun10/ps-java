// N과 M (2) ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S3_15650 {
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        solution();
        bw.flush();
    }

    static void solution() throws Exception {
        boolean[] visited = new boolean[n+1];   // 선택된 숫자 확인
        int[] arr = new int[m];                 // 선택된 숫자 목록
        re_func(0, 1, visited, arr);
    }

    // 백트래킹 함수
    static void re_func(int count, int index, boolean[] visited, int[] arr) throws Exception {
        if (count == m) {   // m개 선택되면 출력
            for (int i = 0; i < m; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write('\n');
            return;
        }
        // 현재 값보다 큰 숫자만 선택 가능, 중복 불가
        for (int i = index; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = i;
                re_func(count+1, i, visited, arr);
                visited[i] = false;
            }
        }
    }
}
