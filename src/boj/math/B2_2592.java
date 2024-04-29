// 대표값 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class B2_2592 {

    static int[] arr = new int[10];
    static int maxValue = 0;
    static int maxCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        int value = 0;
        int count = 0;
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += arr[i];
            if (arr[i] != value) {
                if (count > maxCount) {
                    maxValue = value;
                    maxCount = count;
                }
                value = arr[i];
                count = 1;
            }
            else {
                count += 1;
            }
        }

        System.out.println(sum / 10);
        System.out.println(maxValue);
    }
}
