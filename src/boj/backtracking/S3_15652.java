// N과 M (4) ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S3_15652 {
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

    static void solution() throws Exception{
        int[] arr = new int[m];         // 선택된 숫자 목록
        re_func(0, 1, arr);
    }

    // 백트래킹 함수
    static void re_func(int count, int index, int[] arr) throws Exception {
        if (count == m) {   // m만큼 뽑으면 출력
            for (int i = 0; i < m; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write('\n');
            return;
        }
        // 현재 값 이상만 뽑을 수 있음
        for (int i = index; i <= n; i++) {
            arr[count] = i;
            re_func(count+1, i, arr);
        }
    }
}
