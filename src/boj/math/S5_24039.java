// 2021은 무엇이 특별할까? ( 정답 )
// 알고리즘: 수학, 에라토스테네스의 체

package boj.math;

import java.io.*;

public class S5_24039 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[200];

        solution();
    }

    static void solution() {

        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 200; i++) {
            if (arr[i] == 0) {
                for (int j = i+i; j < 200; j=j+i) {
                    arr[j] = 1;
                }
            }
        }

        int before = 2;
        for (int i = 3; i < 200; i++) {
            if (arr[i] == 0) {
                if (before * i > n) {
                    System.out.println(before*i);
                    break;
                }
                else {
                    before = i;
                }
            }
        }
    }
}
