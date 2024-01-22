// 방 번호 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;

public class S5_1475 {
    static int n;       // 방 번호
    static int[] arr;   // 필요한 숫자 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[10];

        solution();
    }

    static void solution() {
        int temp = n;
        while (temp > 0) {
            arr[temp%10] += 1;
            temp /= 10;
        }

        int max = 0;        // 6,9를 제외한 필요한 숫자 최댓값
        int sum_6n9 = 0;    // 6과 9 개수 합
        for (int i = 0; i <= 9 ; i++) {
            if (!(i == 6 | i == 9)) {
                max = Math.max(arr[i], max);
            }
            else {
                sum_6n9 += arr[i];
            }
        }

        System.out.println(Math.max(max, sum_6n9/2 + sum_6n9%2));   // 둘중 큰 수가 정답
    }
}
