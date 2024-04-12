// N 과 M (11) ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class S2_15665 {

    static int n, m;
    static Set<Integer> set = new HashSet<>();
    static int[] answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        solution();
    }

    static void solution() throws Exception {

        Integer[] arr = set.toArray(new Integer[set.size()]);
        Arrays.sort(arr);

        dfs(arr, 0, 0);
        bw.flush();
    }

    static void dfs(Integer[] arr, int x, int index) throws Exception {
        if (index == m) {
            for (int i : answer) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            answer[index] = arr[i];
            index += 1;
            dfs(arr, i, index);
            index -= 1;
        }
    }
}
