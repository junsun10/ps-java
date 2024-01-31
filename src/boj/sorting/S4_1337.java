// 올바른 배열 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S4_1337 {

    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int answer = 5;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        solution();
    }

    static void solution() {
        Collections.sort(arr);

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j < 5; j++) {
                if (!arr.contains(arr.get(i)+j)) {
                    count += 1;
                }
            }
            answer = Math.min(count, answer);
        }

        System.out.println(answer);
    }
}
