// 두 용액 ( 정답 )
// 알고리즘: 이분탐색, 두 포인터
// 아래 풀이는 이분탐색 사용

package boj.binary_search;

import java.io.*;
import java.util.*;

public class G5_2470 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        int[] answer = new int[2];  // 정답 용액
        int sum = 2000000000;       // 특성값

        // 용액 하나씩 선택 뒤 이분탐색
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n-1;
            while (start <= end) {
                int mid = (start+end)/2;
                if (i == mid) {         // mid가 현재 선택한 용액인 경우
                    if (arr[i] < 0) {
                        start = mid+1;
                    }
                    else {
                        end = mid-1;
                    }
                }
                else {
                    if (arr[i] + arr[mid] < 0) {
                        if (Math.abs(arr[i] + arr[mid]) < sum) {
                            sum = Math.abs(arr[i] + arr[mid]);
                            answer[0] = arr[i];
                            answer[1] = arr[mid];
                        }
                        start = mid + 1;
                    }
                    else if (arr[i] + arr[mid] > 0) {
                        if (Math.abs(arr[i] + arr[mid]) < sum) {
                            sum = Math.abs(arr[i] + arr[mid]);
                            answer[0] = arr[i];
                            answer[1] = arr[mid];
                        }
                        end = mid - 1;
                    }
                    else {
                        answer[0] = arr[i];
                        answer[1] = arr[mid];
                        sum = 0;
                        break;
                    }
                }
            }
        }
        Arrays.sort(answer);
        System.out.printf("%d %d", answer[0], answer[1]);
    }
}
