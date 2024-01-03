// 회전 초밥 ( 정답 )
// 알고리즘: 브루트포스
// 두 포인터를 사용해 최적화 가능

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class S1_2531 {
    static int n, d, k, c;  // n: 접시의 수, d: 초밥의 가짓수, k: 연속해서 먹는 초밥 수, c: 쿠폰번호
    static int[] arr;   // 회전초밥 배열
    static boolean[] visited;   // 선택한 초밥
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        for (int i = 0; i < n; i++) {   // 첫 자리부터 완전 탐색
            count(i);
        }
        System.out.println(answer);
    }

    static void count(int index) {
        visited = new boolean[d + 1];
        int tempAnswer = 0;
        for (int i = index; i < index+k; i++) {
            if (i < n) {
                if (!visited[arr[i]]) {
                    tempAnswer += 1;
                    visited[arr[i]] = true;
                }
            }
            else {  // 배열 인덱스가 넘어간 경우
                if (!visited[arr[i - n]]) {
                    tempAnswer += 1;
                    visited[arr[i - n]] = true;
                }
            }
        }
        if (!visited[c]) {
            tempAnswer += 1;
        }
        answer = Math.max(tempAnswer, answer);
    }
}
