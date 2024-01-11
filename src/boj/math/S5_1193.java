// 분수찾기 ( 정답 )
// 알고리즘: 수학

package boj.math;

import java.util.*;

public class S5_1193 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int x, y;

        int i = 1;
        while (n > i) {
            n -= i;
            i += 1;
        }
        if (i % 2 == 0) {
            y = i - n + 1;
            x = n;
        }
        else {
            x = i - n + 1;
            y = n;
        }
        System.out.printf("%d/%d",x,y);
    }
}
