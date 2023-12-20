// 회사에 있는 사람 ( 정답 )
// 알고리즘: 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class S5_7785 {
    static int n;
    static HashMap<String, Boolean> map = new HashMap<>();
    static ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("enter")) {
                map.put(name, true);
            }
            else {
                map.put(name, false);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s)) {
                arr.add(s);
            }
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
