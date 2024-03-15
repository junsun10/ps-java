// 귀걸이 ( 정답 )
// 알고리즘: 구현, 문자열

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S5_1380 {

    static int n;
    static String[] name;
    static HashMap<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = 0;
        while (true) {
            t += 1;

            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            name = new String[n];
            map.clear();

            for (int i = 0; i < n; i++) {
                name[i] = br.readLine();
            }

            for (int i = 0; i < 2*n-1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken());
                st.nextToken();

                if (map.containsKey(num)) {
                    map.put(num, true);
                }
                else {
                    map.put(num, false);
                }
            }

            solution(t);
        }
    }

    static void solution(int t) {
        for (Integer index : map.keySet()) {
            if (map.get(index) == false) {
                System.out.printf("%d %s\n", t, name[index-1]);
                break;
            }
        }
    }
}
