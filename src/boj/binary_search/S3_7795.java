// 먹을 것인가 먹힐 것인가 ( 정답 )
// 알고리즘: 이분탐색

package boj.binary_search;

import java.io.*;
import java.util.*;

public class S3_7795 {
    static int sizeA, sizeB;
    static int[] arrA, arrB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 수
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sizeA = Integer.parseInt(st.nextToken());
            sizeB = Integer.parseInt(st.nextToken());

            arrA = new int[sizeA];
            arrB = new int[sizeB];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < sizeA; j++) {
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < sizeB; j++) {
                arrB[j] = Integer.parseInt(st.nextToken());
            }

            solution();
        }
    }
    static void solution() {
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int answer = 0;
        // 모든 A 원소에 대하여 이분탐색
        for (int i = 0; i < sizeA; i++) {
            int value = arrA[i];
            int start = 0;
            int end = sizeB-1;
            int temp = -1;  // value보다 작은 값의 인덱스중 최댓값

            while (start <= end) {
                int mid = (start+end)/2;
                if (arrB[mid] >= value) {
                    end = mid - 1;
                }
                else {
                    temp = mid;
                    start = mid + 1;
                }
            }

            answer += temp+1;
        }
        System.out.println(answer);
    }
}
