// 주식 ( 정답 )
// 알고리즘: 그리디
// 문제에서 "답은 부호있는 64bit 정수형으로 표현 가능하다." 주의

package boj.greedy;

import java.io.*;
import java.util.*;

public class S2_11501 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());    // 날의 수
            int[] arr = new int[n];                     // 주가 정보 저장
            st = new StringTokenizer(br.readLine(), " ");   // 주가 정보 읽기
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            solution(n, arr);   // 풀이 함수
        }
        bw.flush();
    }

    // 풀이 함수
    // 뒤에서부터 진행, 최댓값에서 현재 주가를 빼면 이익이 됨
    public static void solution(int n, int[] arr) throws Exception {
        long total = 0;             // 이익 저장, 문제 조건에 따라 int는 불가
        long maxValue = arr[n-1];   // 최대 주가
        for (int i = n-2; i >= 0; i--) {    // 뒤에서부터 진행
            if (arr[i] <= maxValue) {       // 최댓값보다 작거나 같으면 이익 추가
                total += maxValue - arr[i];
            }
            else {                          // 최댓값 갱신
                maxValue = arr[i];
            }
        }
        bw.write(total+"\n");
    }
}
