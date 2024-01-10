// 인사성 밝은 곰곰이 ( 정답 )
// 알고리즘: 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class S4_25192 {
    static int n;
    static int answer = 0;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {    // 새로운 유저가 들어오면
                answer += map.size();       // 기존 고유 채팅 수를 정답에 추가한 뒤
                map.clear();                // 초기화
            }
            else {
                if (!map.containsKey(input)) {  // 처음 채팅한 경우
                    map.put(input, 1);          // 맵에 추가
                }
            }
        }
        answer += map.size();
        System.out.println(answer);
    }
}
