// 비슷한 단어 ( 정답 )
// 알고리즘: 구현, 문자열

package boj.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S2_2607 {
    public static int n;    // 단어의 개수
    public static String word;  // 첫번째 단어
    public static HashMap<Character, Integer> wordMap = new HashMap<>();    // 첫번째 단어 구성
    public static int answer;   // 정답

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        word = br.readLine();
        // 첫번째 단어 구성 확인
        for (int i = 0; i < word.length(); i++) {
            if (wordMap.containsKey(word.charAt(i))) {
                wordMap.put(word.charAt(i), wordMap.get(word.charAt(i))+1);
            }
            else {
                wordMap.put(word.charAt(i), 1);
            }
        }

        // 두번째 단어부터 비교
        for (int i = 0; i < n-1; i++) {
            String w = br.readLine();
            solution(w);    // 풀이 함수
        }

        System.out.println(answer);
    }

    // 풀이 함수
    public static void solution(String w) {
        HashMap<Character, Integer> map = new HashMap<>();  // 첫번째 단어 구성 복사할 맵
        for (Character c : wordMap.keySet()) {
            map.put(c, wordMap.get(c));
        }

        for (int i = 0; i < w.length(); i++) {
            // w의 알파벳이 맵에 있으면 -1
            if (map.containsKey(w.charAt(i))) {
                map.put(w.charAt(i), map.get(w.charAt(i))-1);
            }
            // 없으면 -1 추가
            else {
                map.put(w.charAt(i), -1);
            }
        }

        int countPlus = 0;  // 첫번째 단어에 남아있는 알파벳 개수
        int countMinus = 0; // 첫번째 단어에 없던 알파벳 개수
        for (Character c: map.keySet()) {
            if (map.get(c) < 0) {
                countMinus += -1 * map.get(c);
            }
            else if (map.get(c) > 0) {
                countPlus += map.get(c);
            }
        }
        // 합이 1보다 같거나 작으면 하나를 더하거나 빼서 같은 구성 가능, 플러스와 마이너스가 모두 1이면 한 문자를 바꿔서 같은 구성 가능
        if (countPlus+countMinus <= 1 | (countPlus == 1 & countMinus == 1)) {
            answer += 1;
        }
    }
}
