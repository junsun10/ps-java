// 크로아티아 알파벳 ( 정답 )
// 알고리즘: 구현, 문자열

package boj.string;

import java.io.*;
import java.util.*;

public class S5_2941 {

    static HashMap<String, Boolean> map = new HashMap<>();
    static String input;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        init();
        solution();
    }

    static void init() {
        map.put("c=", true);
        map.put("c-", true);
        map.put("dz=", true);
        map.put("d-", true);
        map.put("lj", true);
        map.put("nj", true);
        map.put("s=", true);
        map.put("z=", true);
    }

    static void solution() {
        int len = input.length();
        int index = 0;
        while (index < len) {
            if (index+2 < len) {
                String str = input.substring(index, index + 3);
                if (map.get(str) != null) {
                    answer += 1;
                    index += 3;
                    continue;
                }
            }
            if (index+1 < len) {
                String str = input.substring(index, index + 2);
                if (map.get(str) != null) {
                    answer += 1;
                    index += 2;
                    continue;
                }
            }
            answer += 1;
            index += 1;
        }

        System.out.println(answer);
    }
}
