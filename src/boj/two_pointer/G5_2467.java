// 용액 ( 정답 )
// 알고리즘: 투 포인터
// 투 포인터를 사용해 두 용액의 합의 절댓값의 최솟값 계산

package boj.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class G5_2467 {
    public static int n;        // 전체 용액의 수
    public static int[] arr;    // 용액들의 특성값 저장 배열
    public static int[] answer = new int[2]; // 정답값

    public static void main(String[] args) throws Exception {
        read();     // 입력 함수
        solution(); // 풀이 함수
        System.out.println(answer[0]+" "+answer[1]);    // 정답 출력
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 전체 용액의 수 입력
        arr = new int[n];   // 용액들의 특성값을 저장할 배열 초기화

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 용액의 특성값 저장
        }
    }

    // 풀이 함수
    // 투 포인터를 사용해 두 용액의 합의 절댓값의 최솟값 계산
    public static void solution() {
        int minSum = 2000000000;        // 두 용액의 합의 절댓값의 최솟값
        int[] minSumArr = new int[2];   // 최솟값을 만드는 두 용액의 특성값
        int start = 0;  // 시작 포인터
        int end = n-1;  // 끝 포인터

        Arrays.sort(arr);   // 투 포인터를 사용하기 위해 배열 정렬

        // 두 포인터가 만나면 멈춤
        while (start < end) {
            int temp = arr[start] + arr[end];   // 두 용액의 합
            int sum = temp;
            // 0보다 작으면 -1 곱함
            if (temp < 0) {
                sum *= -1;
            }

            // 현재 값이 기존보다 작으면 갱신
            if (sum < minSum) {
                minSum = sum;
                minSumArr[0] = arr[start];
                minSumArr[1] = arr[end];
            }

            // 합이 0인 경우 종료
            if (temp == 0) {
                break;
            }
            // 합이 0보다 작은 경우 시작 지점을 옮김
            else if (temp < 0) {
                start += 1;
            }
            // 합이 0보다 큰 경우 끝 지점을 옮김
            else {
                end -= 1;
            }
        }
        answer = minSumArr; // 정답 저장
    }
}
