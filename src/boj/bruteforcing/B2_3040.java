// 백설 공주와 일곱 난쟁이 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;

public class B2_3040 {

    static int[] arr = new int[9];
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        solution();
    }

    static void solution() {

        int p1 = 0;
        int p2 = 0;
        boolean end = false;

        for (int i = 0; i < 8; i++) {

            if (end) {
                break;
            }

            for (int j = i+1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                   p1 = i;
                   p2 = j;
                   end = true;
                   break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != p1 & i != p2) {
                System.out.println(arr[i]);
            }
        }
    }
}
