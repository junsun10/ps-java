// 사과 담기 게임 ( 그리디 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S5_2828 {

    static int n, m;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine())-1;
        }

        solution();
    }

    static void solution() {
        int left = 0;
        int right = m-1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= left & arr[i] <= right) {
                continue;
            }
            else if (arr[i] < left) {
                answer += left - arr[i];
                int temp = left - arr[i];
                left -= temp;
                right -= temp;
            }
            else {
                answer += arr[i] - right;
                int temp = arr[i] - right;
                left += temp;
                right += temp;
            }
        }

        System.out.println(answer);
    }
}
