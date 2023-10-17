// 등수 구하기 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S4_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] rank = new int[n];
        int answer = -1;
        boolean check = false;

        if (n == 0) {
            System.out.println(1);
        }
        else {
            int temp;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                temp = Integer.parseInt(st.nextToken());
                rank[i] = temp;
                if (!check && score >= temp) {
                    answer = i;
                    check = true;
                }
            }
            if (!check) {
                if (n < p) {
                    System.out.println(n+1);
                }
                else {
                    System.out.println(-1);
                }
            }
            else {
                if (n < p) {
                    System.out.println(answer + 1);
                } else {
                    // 새 점수가 이전 점수보다 높을 때만 갱신 가능
                    if (rank[n - 1] == score) {
                        System.out.println(-1);
                    } else {
                        System.out.println(answer + 1);
                    }
                }
            }
        }
    }
}
