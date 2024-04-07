// 차집합 ( 정답 )
// 알고리즘: 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class S4_1822 {

    static int n, m;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, 0);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (map.containsKey(x)) {
                map.remove(x);
            }
        }

        System.out.println(map.size());
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Integer i : list) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
