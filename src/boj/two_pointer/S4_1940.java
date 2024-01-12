// 주몽 ( 정답 )
// 알고리즘: 두 포인터, 정렬

package boj.two_pointer;

import java.io.*;
import java.util.*;

public class S4_1940 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int answer = 0;

        while (left < right) {  // 양 끝에서 시작, 만날 때까지
            if (arr[left] + arr[right] == m) {  // 합이 m이면 정답 증가
                answer += 1;
                left += 1;
                right -= 1;
            }
            else if (arr[left] + arr[right] < m) {  // 합이 m보다 작으면 left 증가
                left += 1;
            }
            else {  // 합이 m보다 크면 right 감소
                right -= 1;
            }
        }
        System.out.println(answer);
    }
}
