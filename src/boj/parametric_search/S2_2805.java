// 나무 자르기 ( 정답 )
// 알고리즘: 매개 변수 탐색

package boj.parametric_search;

import java.io.*;
import java.util.*;

public class S2_2805 {
    static int n, m;    // n: 나무의 수, m: 필요한 나무 길이
    static int[] arr;   // 나무 목록

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        // 가능한 최대 높이를 매개 변수 탐색을 통해 구함
        int start = 0;
        int end = 2000000000;
        int answer = 0;
        while (start <= end) {
            int mid = (start+end)/2;    // 높이 선택
            long sum = 0;               // sum의 크기는 int를 벗어날 수 있음
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += arr[i]-mid;
                }
            }

            if (sum >= m) {     // 자른 나무 길이가 목표보다 크거나 같으면
                answer = mid;   // 정답에 저장한 뒤
                start = mid+1;  // 높이를 높여서 반복
            }
            else {              // 목표보다 작으면
                end = mid-1;    // 높이를 낮춰서 반복
            }
        }
        System.out.println(answer);
    }
}
