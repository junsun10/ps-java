// 기타 레슨 ( 전답 )
// 알고리즘: 이분탐색

package boj.binary_search;

import java.io.*;
import java.util.*;

public class S1_2343 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    // 가능한 최소 길이를 이분탐색으로 찾음
    static void solution() {
        int start = 1;
        int end = Integer.MAX_VALUE-1;
        int mid = 0;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            mid = (start + end) / 2;
            int c = check(mid);     // check함수에서 가능한지 확인
            if (c == 1) {
                start = mid + 1;
            }
            else if (c == -1) {
                end = mid - 1;
                min = Math.min(min, mid);
            }
        }
        System.out.println(min);
    }

    static int check(int len) {
        int temp = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] > len) {         // 길이 하나가 기준을 넘는 경우 종료
                count = m+1;
                break;
            }
            if (temp + arr[i] <= len) { // 연결할 수 있는 경우
                temp += arr[i];
            }
            else {                      // 연결할 수 없는 경우
                count += 1;
                temp = arr[i];
            }
        }
        count += 1;     // 마지막 블루레이 추가

        if (count > m) {    // 길이를 늘려야 함
            return 1;
        }
        else {              // <=를 하는 이유는 m보다 작은 경우에도 정답이 될 수 있음
            return -1;      // 강의 하나의 크기가 너무 크면 m보다 작아질 수 있음
        }
    }
}
