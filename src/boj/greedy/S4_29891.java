// 체크포인트 달리기 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S4_29891 {

    static int n, k;
    static Integer[] arr;
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }

    static void solution() {
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        for (Integer i : arr) {
            if (i >= 0) {
                plus.add(i);
            }
            else {
                minus.add(i);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int index = 0;
        while (index < plus.size()) {
            answer += plus.get(index)*2;
            index += k;
        }
        index = 0;
        while (index < minus.size()) {
            answer -= minus.get(index)*2;
            index += k;
        }
        System.out.println(answer);
    }
}
