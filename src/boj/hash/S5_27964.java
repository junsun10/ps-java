// 콰트로치즈피자 ( 정답 )
// 알고리즘: 문자열, 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class S5_27964 {

    static int n;
    static String[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            if (name.length() < 6) {
                continue;
            }
            if (name.substring(name.length()-6, name.length()).equals("Cheese")) {
                set.add(name);
            }
        }

        if (set.size() >= 4) {
            System.out.println("yummy");
        }
        else {
            System.out.println("sad");
        }
    }
}
