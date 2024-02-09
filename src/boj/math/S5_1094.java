// 막대기 ( 정답 )
// 알고리즘: 수학
// 비트마스킹 가능

package boj.math;

import java.io.*;
import java.util.*;

public class S5_1094 {

    static int x;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);
        int sum = 64;

        while (sum > x) {
            Integer min;
            min = pq.poll();
            if (sum - min/2 >= x) {
                pq.add(min/2);
                sum -= min/2;
            }
            else {
                pq.add(min/2);
                pq.add(min/2);
            }
        }

        System.out.println(pq.size());
    }
}
