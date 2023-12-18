// 두 수의 합 ( 정답 )
// 알고리즘: 두 포인터, 정렬

package boj.two_pointer;

import java.io.*;
import java.util.*;

public class S3_3273 {
    static int n;
    static int[] arr;
    static int x;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                answer += 1;
                start += 1;
            }
            else if (arr[start] + arr[end] > x) {
                end -= 1;
            }
            else {
                start += 1;
            }
        }

        System.out.println(answer);
    }
}
