// 농구 경기 ( 정답 )
// 알고리즘: 문자열

package boj.string;

import java.io.*;
import java.util.*;

public class B2_1159 {

    static int n;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            Character c = name.charAt(0);

            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c, 1);
            }
        }

        boolean have = false;

        for (Character c : map.keySet()) {
            if (map.get(c) >= 5) {
                System.out.printf("%c", c);
                have = true;
            }
        }

        if (!have) {
            System.out.println("PREDAJA");
        }

    }
}
