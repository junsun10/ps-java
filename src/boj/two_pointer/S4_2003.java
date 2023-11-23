// 수들의 합 2 ( 정답 )
// 알고리즘: 두 포인터, 누적 합

package boj.two_pointer;

import java.io.*;
import java.util.*;

public class S4_2003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        int answer = 0;
        int sum = arr[0];
        int left = 0, right = 0;

        while (true) {
            if (sum == m) {
                answer += 1;
                sum -= arr[left];
                left += 1;
            }
            else if (sum > m) {
                sum -= arr[left];
                left += 1;
            }
            else {
                right += 1;
                if (right == n) {
                    break;
                }
                sum += arr[right];
            }
        }
        System.out.println(answer);
    }
}
