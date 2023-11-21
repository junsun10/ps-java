// N 과 M (1) ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S3_15649 {
    static int n;
    static int m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        solution();
        bw.flush();
    }

    static void solution() throws Exception {
        boolean[] visited = new boolean[n+1];   // 선택된 숫자 확인
        int[] list = new int[m];                // 선택된 숫자 목록
        re_func(0, visited, list);
    }

    static void re_func(int count, boolean[] visited, int[] list) throws Exception {
        if (count == m) {   // m개 선택되면 출력
            for(int value: list) {
                bw.write(value+" ");
            }
            bw.write('\n');
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {      // 선택되지 않은 수 확인
                    list[count] = i;    // 목록에 추가
                    visited[i] = true;  // 방문 처리
                    re_func(count+1, visited, list);
                    visited[i] = false;
                }
            }
        }
    }
}
