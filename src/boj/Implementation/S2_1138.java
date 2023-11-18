// 한 줄로 서기 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S2_1138 {
    public static int n;        // 사람 수
    public static int[] arr;    // 왼쪽에 있는 자기보다 큰 사람의 수
    public static int[] answer; // 정답

    public static void main(String[] args) throws Exception {
        read();
        solution();

        for (int i : answer) {
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solution() {
        for (int i = 0; i < n; i++) {
            int count = 0;  // 빈자리 카운트
            for (int j = 0; j < n; j++) {
                // arr[i]만큼 비우고 현재 위치 비어있으면 추가
                if (count == arr[i] & answer[j] == 0) {
                    answer[j] = i+1;
                    break;
                }
                // 현재 위치가 비어있으면 카운트 증가
                if (answer[j] == 0) {
                    count += 1;
                }
            }
        }
    }
}
