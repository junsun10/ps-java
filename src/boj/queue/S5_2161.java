// 카드1 ( 정답 )
// 알고리즘: 큐

package boj.queue;

import java.io.*;
import java.util.*;

public class S5_2161 {
    static int n;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        while (!dq.isEmpty()) {
            int top = dq.pop();
            System.out.printf("%d ", top);
            if (dq.isEmpty()) {
                break;
            }
            int next = dq.pop();
            dq.add(next);
        }
        System.out.println();
    }
}
