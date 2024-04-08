// 붙임성 좋은 총총이 ( 정답 )
// 알고리즘: 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class S4_26069 {

    static int n;
    static int answer = 0;
    static HashMap<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        Boolean start = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();

            if (!start) {
                if (a.equals("ChongChong")) {
                    map.put(a, true);
                    map.put(b, true);
                    answer += 2;
                    start = true;
                }
                else if (b.equals("ChongChong")) {
                    map.put(a, true);
                    map.put(b, true);
                    answer += 2;
                    start = true;
                }
            }
            else {
                if (map.containsKey(a) & map.containsKey(b)) {
                    continue;
                }
                else if (map.containsKey(a)) {
                    map.put(b, true);
                    answer += 1;
                }
                else if (map.containsKey(b)) {
                    map.put(a, true);
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}
