// 영단어 암기는 괴로워 ( 정답 )
// 알고리즘: 정렬, 맵
// 해시맵을 사용해 단어장 저장
// 문제 조건에 맞게 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S3_20920 {
    static int n, m;    // n: 단어의 개수, m: 외울 단어 길이 기준

    static class Word implements Comparable<Word> { // 정렬을 위한 단어 클래스 정의
        String word;

        Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word x) {
            // 길이가 길면 먼저 옴
            if (this.word.length() > x.word.length()) {
                return -1;  // 내림차순
            }
            // 길이가 같으면 사전 순
            else if (this.word.length() == x.word.length()) {
                // 앞자리부터 사전 순 비교
                for (int i = 0; i < this.word.length(); i++) {
                    if (this.word.charAt(i) > x.word.charAt(i)) {
                        return 1;
                    }
                    else if (this.word.charAt(i) < x.word.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            }
            else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>(); // (단어, 등장 횟수)

        // 단어 입력
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {   // m보다 긴 경우만 저장
                if (map.containsKey(word)) {    // 이미 key가 존재하면 횟수 증가
                    map.put(word, map.get(word) + 1);
                } else {    // 처음인 경우 맵에 저장
                    map.put(word, 1);
                }
            }
        }

        HashMap<Integer, ArrayList<Word>> countMap = new HashMap<>(); // key: 등장 횟수, value: 단어 목록

        // countMap에 할당
        for (String s : map.keySet()) {
            if (countMap.containsKey(map.get(s))) { // 등장 횟수 key가 있는 경우 목록에 추가
                ArrayList<Word> temp = countMap.get(map.get(s));
                temp.add(new Word(s));
                countMap.put(map.get(s),temp);
            }
            else {  // 등장 횟수 key가 없는 경우
                ArrayList<Word> temp = new ArrayList<>();
                temp.add(new Word(s));
                countMap.put(map.get(s), temp);
            }
        }

        // 등장 횟수 별로 정렬한 임시 정답 배열
        ArrayList<ArrayList<String>> tempAnswer = new ArrayList<>();

        // 등장 횟수 1부터 진행
        for (Integer integer : countMap.keySet()) {

            // 문제 조건에 맞게 정렬
            ArrayList<Word> words = countMap.get(integer);
            Collections.sort(words);

            // 정렬된 순서대로 temp에 저장
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < countMap.get(integer).size(); i++) {
                temp.add(countMap.get(integer).get(i).word);
            }
            // integer 값이 오름차순으로 증가하므로 tempAnswer 맨 앞에 저장
            tempAnswer.add(0,temp);
        }

        // 버퍼에 저장
        for (ArrayList<String> strings : tempAnswer) {
            for (String string : strings) {
                bw.write(string+"\n");
            }
        }
        bw.flush(); // 정답 출력
    }

}

