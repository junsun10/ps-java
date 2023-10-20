// 블로그 ( 정답 )
// 알고리즘: 슬라이딩 윈도우, 누적합
// 슬라이딩 윈도우 또는 누적합으로 풀이 가능
// 아래 코드는 슬라이딩 윈도우 사용

package boj.sliding_window;

import java.io.*;
import java.util.*;

public class S3_21921 {
    static int n,x; // n: 블로그를 시작하고 지난 일수, x: 계산할 날짜 범위
    static int[] arr;   // 일별 방문자 배열
    static int sumValue = 0;    // 슬라이딩 윈도우에 사용할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // n,x 입력, 배열 초기화
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];

        // 일별 방문자수 할당
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount;   // 방문자 수의 최댓값
        int rangeCount; // 최대값 기간
        for (int i = 0; i < x; i++) {   // 첫번째 범위 계산
            sumValue += arr[i];
        }
        // 첫번째 범위로 최댓값과 기간 갱신
        maxCount = sumValue;
        rangeCount = 1;

        // 슬라이딩 윈도우
        for (int i = 1; i < n - x + 1; i++) {
            // 맨앞 날짜 빼고 맨뒤 날짜 더함
            sumValue -= arr[i-1];
            sumValue += arr[i+x-1];

            if (sumValue > maxCount) {  // 최댓값이 크면 갱신
                maxCount = sumValue;
                rangeCount = 1;
            }
            else if (sumValue == maxCount) {    // 최댓값이 같으면 기간만 추가
                rangeCount += 1;
            }
        }
        if (maxCount == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(maxCount);
            System.out.println(rangeCount);
        }
    }
}
