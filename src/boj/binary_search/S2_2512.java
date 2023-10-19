// 예산 ( 정답 )
// 알고리즘: 이분 탐색, 매개 변수 탐색
// 상한액을 이분 탐색을 통해 구함

package boj.binary_search;

import java.io.*;
import java.util.*;

public class S2_2512 {
    static int n;   // 지방의 수
    static int[] arr;   // 각 지방의 예산 요청
    static int m;   // 총 예산
    static int totalInput;  // 예산 요청의 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 지방의 수 입력
        arr = new int[n];   // 예산 요청 배열 초기화
        st = new StringTokenizer(br.readLine(), " ");   // 예산 요청 입력
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 배열에 할당
            totalInput += arr[i];   // 총 예산 요청 계산
        }
        m = Integer.parseInt(br.readLine());    // 총 예산 입력

        if (totalInput <= m) {  // 예산 요청의 합이 총 예산보다 작으면 최대 예산 출력
            System.out.println(Arrays.stream(arr).max().getAsInt());
        }
        else {  // 상한액 이분탐색
            int start = 0;
            int end = Arrays.stream(arr).max().getAsInt();
            int point;
            int answer = start; // 정답 저장

            // 이분 탐색
            while (start <= end) {
                point = (start + end) / 2;
                if (check(point)) { // 가능한 상한액인 경우
                    start = point+1;
                    answer = point; // 정답에 저장
                }
                else {  // 불가능한 상한액인 경우
                    end = point-1;
                }
            }
            System.out.println(answer);
        }
    }

    // 상한액을 입력받아 예산 내로 배정 가능하지 확인하는 함수
    public static boolean check(int maxMoney) {
        int total = 0;
        for (int i = 0; i < n; i++) {   // 모든 예산 요청 순환
            if (arr[i] < maxMoney) {    // 상한액보다 작으면 그대로 더함
                total += arr[i];
            }
            else {  // 상한액보다 크면 상한액 더함
                total += maxMoney;
            }
        }
        if (total > m) {    // 예산 초과
            return false;
        }
        else {
            return true;
        }
    }
}
