// 카드2 ( 정답 )
// 알고리즘: 자료구조, 큐

package boj.queue;

import java.io.*;
import java.util.*;

public class S4_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            dq.add(i+1);
        }

        while (true) {
            if (dq.size() == 1) {
                System.out.println(dq.pop());
                break;
            }
            else {
                dq.removeFirst();
                int temp = dq.removeFirst();
                dq.add(temp);
            }
        }
    }
}
