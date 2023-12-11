// 베르트랑 공준 ( 정답 )
// 알고리즘: 소수

package boj.math;

import java.io.*;

public class S2_4948 {
    static int n;
    static int[] arr = new int[246913];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        solution();
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            System.out.println(arr[n*2] - arr[n]);
        }
    }

    // 전체 소수 찾기
    static void solution() {
        arr[1] = 1;
        for (int i = 2; i < 246913; i++) {
            if (check(i)) {
                arr[i] = arr[i-1] + 1;
            }
            else {
                arr[i] = arr[i-1];
            }
        }
    }

    // 소수인지 확인
    static boolean check(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x%i == 0) {
                return false;
            }
        }
        return true;
    }
}