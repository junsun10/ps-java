// 배열 합치기 ( 정답 )
// 알고리즘: 두 포인터

package boj.two_pointer;

import java.io.*;
import java.util.*;

public class S5_11728 {

    static int n, m;
    static int[] arrA, arrB;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrA = new int[n];
        arrB = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int indexA = 0, indexB = 0;

        while (indexA < n & indexB < m) {
            if (arrA[indexA] < arrB[indexB]) {
                sb.append(arrA[indexA] + " ");
                indexA += 1;
            } else if (arrA[indexA] > arrB[indexB]) {
                sb.append(arrB[indexB] + " ");
                indexB += 1;
            } else {
                sb.append(arrA[indexA] + " " + arrB[indexB] + " ");
                indexA += 1;
                indexB += 1;
            }
        }

        // arrA가 끝난 경우
        if (indexA == n) {
            while (indexB < m) {
                sb.append(arrB[indexB] + " ");
                indexB += 1;
            }
        }
        // arrB가 끝난 경우
        else if (indexB == m) {
            while (indexA < n) {
                sb.append(arrA[indexA] + " ");
                indexA += 1;
            }
        }
        System.out.println(sb);
    }
}
