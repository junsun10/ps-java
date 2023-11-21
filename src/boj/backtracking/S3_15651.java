// N 과 M (3) ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S3_15651 {
    public static int n;
    public static int m;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        solution();
        bw.flush();
    }

    public static void solution() throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        re_func(arr);
    }

    // 백트래킹 함수
    public static void re_func(ArrayList<Integer> arr) throws Exception {
        if (arr.size() == m) {              // 크기가 m이면 출력
            for(int i: arr) {
                bw.write(i+" ");
            }
            bw.write('\n');
            return;
        }
        for (int i = 1; i <= n; i++) {      // 중복 허용해서 뽑기
            arr.add(i);
            re_func(arr);
            arr.remove(arr.size()-1);
        }
    }
}
