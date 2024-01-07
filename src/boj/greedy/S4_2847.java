// 게임을 만든 동준이 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;

public class S4_2847 {
    static int n;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
        System.out.println(answer);
    }

    static void solution() {
        if (n == 1) {
            System.out.println(0);
        }
        else {
            for (int i = n-2; i >= 0 ; i--) {
                if (arr[i] >= arr[i+1]) {   // i+1보다 1 작게 만든다
                    answer += arr[i] - arr[i+1] + 1;
                    arr[i] = arr[i+1] - 1;
                }
            }
        }

    }
}
