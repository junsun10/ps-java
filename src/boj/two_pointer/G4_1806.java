// 부분합 ( 정답 )
// 알고리즘: 두 포인터, 누적 합

package boj.two_pointer;

import java.io.*;
import java.util.*;

public class G4_1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        int p1 = 0, p2 = 0;     // p1: 왼쪽 인덱스, p2: 오른쪽 인덱스
        int answer = n+1;       // 길이 최솟값
        int sum = arr[0];       // 0번에서 시작
        while (p2 < n) {
            if (sum >= s)  {    // 합이 s 이상이면 정답 갱신
                answer = Math.min(answer,(p2-p1+1));
                sum -= arr[p1]; // 왼쪽 한개 제거
                p1 += 1;
            }
            else {              // 합이 s 미만이면 오른쪽 증가
                p2 += 1;
                if (p2 == n) {  // 마지막까지 확인했으면 종류
                    break;
                }
                sum += arr[p2];
            }
        }
        if (answer == n+1) {    // 불가능한 경우
            System.out.println(0);
        }
        else {
            System.out.println(answer);
        }
    }
}
