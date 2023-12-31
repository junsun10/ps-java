// 세수정렬 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class B4_2752 {
    static int[] arr = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
