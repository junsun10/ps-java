// 기타리스트 ( dp )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S1_1495 {
    static int n,s,m;
    static int[] arr;
    static ArrayList<HashSet<Integer>> dp = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        for (int i = 0; i <= n; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(0).add(s);

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            check = false;      // 볼륨 조절 가능 여부
            for (Integer p : dp.get(i-1)) {     // 이전에 사용 가능한 볼륨
                if (p - arr[i] >= 0) {
                    dp.get(i).add(p-arr[i]);    // 가능하면 추가
                    check = true;
                }
                if (p + arr[i] <= m) {
                    dp.get(i).add(p+arr[i]);    // 가능하면 추가
                    check = true;
                }
            }
            if (!check) {   // 볼륨 조절이 불가능하면 탈출
                break;
            }

        }
        if (check) {
            int max = 0;
            for (Integer i : dp.get(n)) {   // n번째 가능한 볼륨 중 최댓값 선택
                max = Math.max(max, i);
            }
            System.out.println(max);
        }
        else {  // 볼륨 조절이 불가능한 경우
            System.out.println(-1);
        }
    }
}
