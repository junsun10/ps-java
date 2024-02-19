// 성적 통계 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_5800 {

    static int k;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            solution(i+1);
        }
    }

    static void solution(int index) throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = 100;
        int max = 0;
        int gap = 0;
        int before = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
            if (i - before > gap) {
                gap = i - before;
            }
            before = i;
        }

        System.out.printf("Class %d\n", index);
        System.out.printf("Max %d, Min %d, Largest gap %d\n", max, min, gap);
    }
}
