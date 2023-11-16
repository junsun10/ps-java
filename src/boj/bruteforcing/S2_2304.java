// 창고 다각형 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class S2_2304 {
    public static int n;
    public static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 막대의 개수
        arr = new int[n][2];                    // 막대 정보 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // x좌표 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        solution();
    }

    public static void solution() {
        int total = 0;  //  전체 면적
        int temp = 0;
        int index = arr[0][0];
        int maxValue = arr[0][1];
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            // 더 높은 막대 만나면 temp값 total에 저장
            if (arr[i][1] >= maxValue) {
                temp += maxValue*(arr[i][0]-index);
                total += temp;
                temp = 0;
                maxValue = arr[i][1];
                maxIndex = arr[i][0];
                index = arr[i][0];
            }
            // temp값에 면적 저장
            else {
                temp += maxValue*(arr[i][0] - index);
                index = arr[i][0];
            }
        }

        total += maxValue;  // 가장 높은 막대 추가

        // 오른쪽에서 가장 높은 막대까지 계산
        temp = 0;
        maxValue = arr[n-1][1];
        index = arr[n-1][0];
        if (maxIndex != arr[n-1][0]) {
            for (int i = n-1; i > 0; i--) {
                // 가장 높은 막대 위치 만나면 탈출
                if (arr[i][0] == maxIndex) {
                    temp += maxValue*(index-arr[i][0]);
                    total += temp;
                    break;
                }
                if (arr[i][1] >= maxValue) {
                    temp += maxValue*(index-arr[i][0]);
                    total += temp;
                    temp = 0;
                    maxValue = arr[i][1];
                    index = arr[i][0];
                }
                else {
                    temp += maxValue*(index - arr[i][0]);
                    index = arr[i][0];
                }
            }
        }
        System.out.println(total);
    }
}
