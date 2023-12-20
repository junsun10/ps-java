// 전화번호 목록 ( 정답 )
// 알고리즘: 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class G4_5052 {
    static int t, n;
    static HashMap<String, Boolean> map = new HashMap<>();  // 전화번호 목록


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map.clear();
            for (int j = 0; j < n; j++) {
                String num = br.readLine();
                map.put(num, true);
            }

            solution();
        }
    }

    static void solution() {
        boolean valid = true;
        for (String num : map.keySet()) {
            if (!valid) {
                break;
            }
            String temp = "";   //  temp에 전화번호 앞에서 부터 하나씩 추가
            for (int i = 0; i < num.length(); i++) {
                temp += num.charAt(i);
                if (map.containsKey(temp) & !temp.equals(num)) {    // 다른 번호와 겹치는지 확인
                    valid = false;
                    break;
                }
            }
        }
        if (valid) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
