// 임스와 함께하는 미니게임 ( 정답 )
// 알고리즘: 문자열, 집합
// 집합을 사용하여 중복 제거

package boj.hash_set;

import java.io.*;
import java.util.*;

public class S5_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        String g = st.nextToken();
        int game;
        if (g.equals("Y")) {
            game = 1;
        }
        else if (g.equals("F")) {
            game = 2;
        }
        else {
            game = 3;
        }
        int count = 0;

        HashSet<String> arr = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int len = arr.size();
            arr.add(name);
            if (arr.size() == len+1){
                count += 1;
            }
        }

        int answer = count / game;
        System.out.println(answer);
    }
}
