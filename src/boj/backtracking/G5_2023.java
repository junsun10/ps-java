// 신기한 소수 ( 정답 )
// 알고리즘: 백트래킹, 소수

package boj.backtracking;

import java.io.*;

public class G5_2023 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        for (int i = 1; i < 9; i++) {
            dfs(i);
        }
    }

    static void dfs(int x) {
        if (x >= Math.pow(10,n-1) & check(x)) {
            System.out.println(x);
            return;
        }
        if (x < Math.pow(10,n-1) & check(x)) {
            for (int i = 0; i <= 9; i++) {
                dfs(x*10 + i);
            }
        }
    }

    static boolean check(int val) {
        if (val == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i  == 0) {
                return false;
            }
        }
        return true;
    }
}
