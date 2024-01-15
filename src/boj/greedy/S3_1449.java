// 수리공 항승 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S3_1449 {
    static int n, l;    // n: 물이 새는 위치 개수, l: 테이프 길이
    static int[] arr;   // 물이 새는 위치 배열
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        double start = arr[0] - 0.5;    // 시작 위치를 물이 새는 첫번째 위치 + 0.5로 설정
        for (int i = 1; i < n; i++) {
            if (arr[i] + 0.5 > start + l) { // 테이프가 다음 물이 새는 위치 + 0.5 까지 오지 못한 경우
                answer += 1;                // 테이프 개수를 늘림
                start = arr[i] - 0.5;       // 시작 위치를 현재 물이 새는 위치 - 0.5로 설정
            }
        }
        System.out.println(answer);
    }
}
