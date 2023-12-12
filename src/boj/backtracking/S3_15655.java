// N과 M (6) ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S3_15655 {
    static int n,m;
    static int[] arr;
    static int[] pick;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        pick = new int[m];
        back(0,0);
    }

    static void back(int index, int count) {

        if (count == m) {
            for (int i : pick) {
                System.out.printf("%d ", i);
            }
            System.out.println();
            return;
        }

        // 입력받은 수에서 뽑기
        for (int i = index; i < n; i++) {
            pick[count] = arr[i];
            count += 1;
            back(i+1, count);
            count -= 1;
        }
    }
}
