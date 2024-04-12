// 지름길 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S1_1446 {

    static int n, d;
    static HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();    // key 위치로 오는 지름길 목록 저장
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        dp = new int[d + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            int[] temp = new int[2];
            temp[0] = start;
            temp[1] = len;

            if (end > d) {
                continue;
            }

            if (map.containsKey(end)) {
                map.get(end).add(temp);
            }
            else {
                ArrayList<int[]> arr = new ArrayList<>();
                arr.add(temp);
                map.put(end, arr);
            }
        }

        solution();
    }

    static void solution() {
        dp[0] = 0;
        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i-1] + 1;
            if (map.containsKey(i)) {
                for (int j = 0; j < map.get(i).size(); j++) {
                    int[] arr = map.get(i).get(j);

                    if (dp[arr[0]] + arr[1] < dp[i]) {
                        dp[i] = dp[arr[0]] + arr[1];
                    }
                }
            }
        }

        System.out.println(dp[d]);
    }
}