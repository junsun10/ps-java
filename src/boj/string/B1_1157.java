// 단어 공부 ( 정답 )
// 알고리즘: 문자열
// 아스키코드 사용법 익히기

package boj.string;

import java.io.*;
import java.util.*;

public class B1_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if ( word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                arr[word.charAt(i) - 'A'] += 1;
            }
            else {
                arr[word.charAt(i) - 'a'] += 1;
            }
        }

        int max_count = 0;
        ArrayList<Integer> max_index = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (arr[i] == max_count) {
                max_index.add(i);
            }
            else if (arr[i] > max_count) {
                max_count = arr[i];
                max_index.clear();
                max_index.add(i);
            }
        }

        if (max_index.size() == 1) {
            System.out.println((char)(max_index.get(0) + (int)'A'));
        }
        else {
            System.out.println("?");
        }
    }
}
