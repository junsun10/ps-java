// 단어 수학 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class G4_1339 {
    static int n;
    static String[] arr;
    static HashMap<Character, Alpha> alphaMap = new HashMap<>();// 알파벳과 객체 연결
    static HashMap<Character, Boolean> map = new HashMap<>();   // 사용된 알파벳 저장
    static ArrayList<Alpha> alphaArr = new ArrayList<>();       // 정렬을 위한 배열
    static long answer = 0;

    static class Alpha {
        char alpha;
        int count = 0;  // 알파벳의 가중치 값

        Alpha(char a) {
            this.alpha = a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solution();
    }

    static void solution() {
        countAlpha();
        copyArr();
        getAnswer();
        System.out.println(answer);
    }

    // 사용된 알파벳의 가중치 계산 함수
    static void countAlpha() {
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), true);
                    Alpha temp = new Alpha(s.charAt(i));
                    temp.count += Math.pow(10, s.length()-i-1); // x자리수 이면 10^(x-1) 더함
                    alphaMap.put(s.charAt(i), temp);
                }
                else {
                    Alpha temp = alphaMap.get(s.charAt(i));
                    temp.count += Math.pow(10, s.length()-i-1); // x자리수 이면 10^(x-1) 더함
                    alphaMap.put(s.charAt(i), temp);
                }
            }
        }
    }

    // 정렬을 위해 배열로 옮기고 정렬하는 함수
    static void copyArr() {
        for (Alpha value : alphaMap.values()) {
            alphaArr.add(value);
        }
        Collections.sort(alphaArr, new Comparator<Alpha>() {
           @Override
           public int compare(Alpha o1, Alpha o2) {
               return o2.count - o1.count;  // 가중치를 기준으로 내림차순 정렬
           }
        });
    }

    // 정답값 계산 함수
    static void getAnswer() {
        HashMap<Character, Integer> v = new HashMap<>();    // 알파벳과 숫자 매핑
        int value = 9;  // 9부터 시작
        for (Alpha alpha : alphaArr) {
            v.put(alpha.alpha, value);
            value -= 1;
        }

        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                answer += v.get(s.charAt(i)) * Math.pow(10, s.length()-i-1);
            }
        }
    }
}
