// 풍선 터뜨리기 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S3_2346 {
    static int n;
    static int[] arr;           // 풍선 메모
    static boolean[] visited;   // 방문 확인

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int index = 0;
        int count = 1;
        int value = arr[0];
        visited[0] = true;
        System.out.printf("1 ");

        while (count < n) {
            int newIndex = index;
            if (value < 0) {
                int temp = 0;
                while (temp < -value) {
                    newIndex -= 1;
                    if (newIndex < 0) {
                        newIndex += n;
                    }
                    if (!visited[newIndex]) {
                        temp += 1;
                    }
                }
            }
            else {
                int temp = 0;
                while (temp < value) {
                    newIndex += 1;
                    if (newIndex >= n) {
                        newIndex -= n;
                    }
                    if (!visited[newIndex]) {
                        temp += 1;
                    }
                }
            }
            visited[newIndex] = true;   // 방문 처리
            System.out.printf("%d ", newIndex+1);
            count += 1;
            index = newIndex;
            value = arr[newIndex];
        }
        System.out.println();
    }
}
