// 어린 왕자 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.io.*;
import java.util.*;

public class S3_1004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 수
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            // 시작점과 끝점 입력
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 행성계의 개수
            int n = Integer.parseInt(br.readLine());
            // 행성계 저장 (x,y,r)
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            for (int i = 0; i < n; i++) {
                // 시작점과 끝점이 각 행성계 내부에 있으면 true, 외부에 있으면 false
                boolean temp1 = Math.pow(x1-arr[i][0],2)+Math.pow(y1-arr[i][1],2) < Math.pow(arr[i][2],2);
                boolean temp2 = Math.pow(x2-arr[i][0],2)+Math.pow(y2-arr[i][1],2) < Math.pow(arr[i][2],2);

                // 두 점 모두 내부에 있으면 continue
                if (temp1 && temp2) {
                    continue;
                }
                // 한 점만 내부에 있으면 그 행성계를 지나야 함
                else if (temp1 || temp2) {
                    answer += 1;
                }
                // 두 점 모두 외부에 있으면 continue
            }
            System.out.println(answer);
        }
    }
}
