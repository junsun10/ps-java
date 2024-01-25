// 점수 계산 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_2822 {
    static int[][] arr;
    static int[] answer;
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[8][2];
        answer = new int[5];

        for (int i = 0; i < 8; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(br.readLine());
        }

        solution();

        System.out.println(sum);
        for (int i : answer) {
            System.out.printf("%d ", i);
        }
    }

    static void solution() {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < 5; i++) {
            sum += arr[i][1];
            answer[i] = arr[i][0] + 1;
        }
        Arrays.sort(answer);
    }
}
