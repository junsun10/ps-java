// 장신구 명장 임스 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_25496 {

    static int p, n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        p = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (p < 200) {
                p += arr[i];
                answer += 1;
            }
            else {
                break;
            }
        }

        System.out.println(answer);
    }
}
