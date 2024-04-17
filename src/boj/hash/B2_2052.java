// 나머지 ( 정답 )
// 알고리즘: set, 수학

package boj.hash;

import java.io.*;
import java.util.*;

public class B2_2052 {

    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());

            set.add(a % 42);
        }

        System.out.println(set.size());

    }
}
