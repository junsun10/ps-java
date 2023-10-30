// K번째 수 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_11004 {
    public static int n, k;     // n: 수의 개수, k: 찾을 인덱스
    public static int[] arr;    // 입력 리스트

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solution() {
        Arrays.sort(arr);   // 정렬
        System.out.println(arr[k-1]);
    }
}
