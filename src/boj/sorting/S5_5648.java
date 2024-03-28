// 역원소 정렬 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_5648 {

    static int n;
    static String[] arr;
    static Long[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        arr = new String[n];
        answer = new Long[n];
        int count = 0;
        while (true) {

            while (st.hasMoreTokens()) {
                arr[count] = st.nextToken();
                count += 1;
            }

            if (count == n) {
                break;
            }

            st = new StringTokenizer(br.readLine(), " ");
        }

        solution();
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = arr[i].length()-1; j >= 0 ; j--) {
                temp += arr[i].charAt(j);
            }
            answer[i] = Long.parseLong(temp);
        }

        Arrays.sort(answer);
        for (Long i : answer) {
            System.out.println(i);
        }
    }
}
