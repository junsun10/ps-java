// 중복 빼고 정렬하기 ( 정답 )
// 알고리즘: 정렬, set

package boj.hash;

import java.io.*;
import java.util.*;

public class S5_10867 {
    static int n;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        for (Integer i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
