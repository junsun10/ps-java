// 옥상 정원 꾸미기 ( 정답 )
// 알고리즘: 구현
// 스택으로 풀 수 있음

package boj.Implementation;

import java.io.*;

public class G5_6198 {

    static int n;
    static int[] arr;
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    answer += 1;
                }
                else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
