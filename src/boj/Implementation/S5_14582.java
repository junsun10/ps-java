// 오늘도 졌다 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S5_14582 {

    static int[] arr1, arr2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr1 = new int[9];
        arr2 = new int[9];
        for (int i = 0; i < 9; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 9; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int score1 = 0;
        int score2 = 0;
        boolean status = false;
        for (int i = 0; i < 9; i++) {
            score1 += arr1[i];
            if (score1 > score2) {
                status = true;
                break;
            }
            score2 += arr2[i];
        }

        if (status) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
