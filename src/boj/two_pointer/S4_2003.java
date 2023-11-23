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
        int answer = 0;             // 합이 m인 횟수
        int sum = arr[0];           // 누적 합
        int left = 0, right = 0;    // 왼쪽, 오른쪽 인덱스

        while (true) {
            if (sum == m) {         // 정답 조건
                answer += 1;
                sum -= arr[left];
                left += 1;
            }
            else if (sum > m) {     // m보다 크면 왼쪽 줄임
                sum -= arr[left];
                left += 1;
            }
            else {                  // m보다 작으면 오른쪽 늘림
                right += 1;
                if (right == n) {   // 마지막까지 확인하면 종료
                    break;
                }
                sum += arr[right];
            }
        }
        System.out.println(answer);
    }
}
