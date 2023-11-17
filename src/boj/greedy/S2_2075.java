// N번째 큰 수 ( 정답 )
// 알고리즘: 우선순위 큐
// 문제 의도는 우선순위 큐 사용인데 다른 방법 사용

package boj.greedy;

import java.io.*;
import java.util.*;

public class S2_2075 {
    public static int n;
    public static int[][] arr;
    public static int answer;

    public static void main(String[] args) throws Exception {
        read();
        solution();
        System.out.println(answer);
    }

    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void solution() {
        int count = 0;          // n번째 수 카운트

        int[] index = new int[n];       // 각 열의 인덱스
        for (int i = 0; i < n; i++) {   // 맨 아래 인덱스로 초기화
            index[i] = n-1;
        }

        while (true) {
            int maxValue = arr[index[0]][0]; // 이번 턴에 최댓값
            int maxValueIndex = 0;           // 최댓값 소속 열
            for (int i = 0; i < n; i++) {    // 최댓값 찾기
                if (arr[index[i]][i] > maxValue) {
                    maxValue = arr[index[i]][i];
                    maxValueIndex = i;
                }
            }

            index[maxValueIndex] -= 1;  // 해당 열 인덱스 감소
            count += 1;

            if (count == n) {   // n번째 수이면 종료
                answer = maxValue;
                break;
            }
        }
    }
}
