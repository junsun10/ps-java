// 집합의 표현 ( 정답 )
// 알고리즘: 분리 집합, 유니온 파인드

package boj.disjoint_set;

import java.io.*;
import java.util.*;

public class G5_1717 {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                setParent(a, b);
            }
            else {
                int A = checkParent(a);
                int B = checkParent(b);
                if (A == B) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    // union
    static void setParent(int a, int b) {
        int A = checkParent(a);
        int B = checkParent(b);
        if (A == B) {
            return;
        }
        else if (A > B) {
            parent[A] = B;  // 최상위 부모를 대체
        }
        else {
            parent[B] = A;
        }
    }

    // find
    static int checkParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = checkParent(parent[x]);
    }
}
