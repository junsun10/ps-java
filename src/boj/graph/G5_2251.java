// 물통 ( 정답 )
// 알고리즘: bfs

package boj.graph;

import java.io.*;
import java.util.*;

public class G5_2251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, C;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    static void solution() {
        Set<int[]> check = new HashSet<>();     //   이전 a,b,c 상태 저장
        check.add(new int[]{0,0,C});

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0,C});

        while (!dq.isEmpty()) {
            int[] now = dq.pop();
            int[] temp = new int[3];
            int a = now[0], b = now[1], c = now[2];
            // a->b
            if (a > 0 & b < B) {
                if (B-b > a) {
                    int newB = b+a;
                    int newA = 0;
                    temp = new int[]{newA,newB,c};
                }
                else {
                    int newB = B;
                    int newA = a-(B-b);
                    temp = new int[]{newA,newB,c};
                }
                if (!have(temp, check)) {
                    check.add(temp);
                    dq.add(temp);
                }
            }
            // a->c
            if (a > 0 & c < C) {
                if (C-c > a) {
                    int newC = c+a;
                    int newA = 0;
                    temp = new int[]{newA,b,newC};
                }
                else {
                    int newC = C;
                    int newA = a-(C-c);
                    temp = new int[]{newA,b,newC};
                }
                if (!have(temp, check)) {
                    check.add(temp);
                    dq.add(temp);
                }
            }
            // b->a
            if (b > 0 & a < A) {
                if (A-a > b) {
                    int newA = a+b;
                    int newB = 0;
                    temp = new int[]{newA,newB,c};
                }
                else {
                    int newA = A;
                    int newB = b-(A-a);
                    temp = new int[]{newA,newB,c};
                }
                if (!have(temp, check)) {
                    check.add(temp);
                    dq.add(temp);
                }
            }
            // b->c
            if (b > 0 & c < C) {
                if (C-c > b) {
                    int newC = c+b;
                    int newB = 0;
                    temp = new int[]{a,newB,newC};
                }
                else {
                    int newC = C;
                    int newB = b-(C-c);
                    temp = new int[]{a,newB,newC};
                }
                if (!have(temp, check)) {
                    check.add(temp);
                    dq.add(temp);
                }
            }
            // c->a
            if (c > 0 & a < A) {
                if (A-a > c) {
                    int newA = a+c;
                    int newC = 0;
                    temp = new int[]{newA,b,newC};
                }
                else {
                    int newA = A;
                    int newC = c-(A-a);
                    temp = new int[]{newA,b,newC};
                }
                if (!have(temp, check)) {
                    check.add(temp);
                    dq.add(temp);
                }
            }
            // c->b
            if (c > 0 & b < B) {
                if (B-b > c) {
                    int newB = b+c;
                    int newC = 0;
                    temp = new int[]{a,newB,newC};
                }
                else {
                    int newB = B;
                    int newC = c-(B-b);
                    temp = new int[]{a,newB,newC};
                }
                if (!have(temp, check)) {
                    check.add(temp);
                    dq.add(temp);
                }
            }
        }
        // A가 0일때의 C 상태 저장
        Set<Integer> answer = new HashSet<>();
        for (int[] ints : check) {
            if (ints[0] == 0) {
                answer.add(ints[2]);
            }
        }
        Integer[] answerArr = answer.toArray(new Integer[0]);
        Arrays.sort(answerArr);
        for (Integer i : answerArr) {
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    // 현재 상태가 이전에 방문한 상태인지 확인
    static boolean have(int[] temp, Set<int[]> check) {
        for (int[] ints : check) {
            if (ints[0] == temp[0] & ints[1] == temp[1] & ints[2] == temp[2]) {
                return true;
            }
        }
        return false;
    }
}
