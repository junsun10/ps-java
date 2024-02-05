// 소트인사이드 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_1427 {
    static String n;
    static Integer[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        arr = new Integer[n.length()];

        solution();
    }

    static void solution() {
        for (int i = 0; i < n.length(); i++) {
            arr[i] = Integer.parseInt(Character.toString(n.charAt(i)));
        }
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer i : arr) {
            System.out.printf("%d", i);
        }
        System.out.println();
    }
}
