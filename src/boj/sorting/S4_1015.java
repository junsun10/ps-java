// 수열 정렬 ( 정렬 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S4_1015 {
    static int n;       // 수열의 길이
    static int[][] arr; // 배열 A [값, 인덱스]

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());   // 값
            arr[i][1] = i;  // 인덱스
        }

        solution();
    }

    static void solution() {
        // 값에 따라 정렬
        Arrays.sort(arr, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0] - o2[0];
           }
        });

        int[] answer = new int[n];  // 정답 수열
        for (int i = 0; i < n; i++) {
            answer[arr[i][1]] = i;
        }

        for (int i : answer) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
