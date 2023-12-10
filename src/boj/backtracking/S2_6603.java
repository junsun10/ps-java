// 로또 ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S2_6603 {
    static int k;
    static int[] arr;
    static int[] pick;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solution();
            System.out.println();
        }
    }

    static void solution() {
        pick = new int[6];
        back(0,0);
    }

    // 백트래킹으로 조합 만들기
    static void back(int index, int count) {
        if (count == 6) {       // 6개 숫자 골랐으면 출력
            for (int i : pick) {
                System.out.printf("%d ", i);
            }
            System.out.println();
            return;
        }

        for (int i = index; i < k; i++) {
            pick[count] = arr[i];
            count += 1;
            back(i+1,count);
            count -= 1;
        }
    }
}
