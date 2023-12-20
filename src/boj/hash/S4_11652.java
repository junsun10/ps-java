// 카드 ( 정답 )
// 알고리즘: 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class S4_11652 {
    static int n;
    static HashMap<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // map을 사용해 빈도수 계산
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if (map.containsKey(x)) {
                map.put(x, map.get(x)+1);
            }
            else {
                map.put(x, 1);
            }
        }

        long maxValue = 0;  // 최빈값
        int maxCount = 0;   // 최빈값 등장 횟수
        for(long value: map.keySet()) {
            if (map.get(value) == maxCount) {   // 같은 횟수면 작은 수 선택
                maxValue = Math.min(value, maxValue);
            }
            else if (map.get(value) > maxCount) {   // 갱신
                maxValue = value;
                maxCount = map.get(value);
            }
        }
        System.out.println(maxValue);
    }
}
