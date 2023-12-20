// 베스트셀러 ( 정답 )
// 알고리즘: 맵, 문자열

package boj.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class S4_1302 {
    public static int n;    // 팔린 책의 개수
    public static HashMap<String, Integer> books = new HashMap<>(); // 팔린 책들 (이름, 개수)로 저장

    public static void main(String[] args) throws Exception {
        System.out.println(solution());
    }

    // 풀이 함수
    // 가장 많이 팔린 책의 이름 리턴
    public static String solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    // 팔린 책의 개수 입력

        int maxCount = 0;
        String maxTitle = "";

        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            // 아직 팔린적 없는 책인 경우
            if (!books.containsKey(title)) {
                // 처음으로 팔린 책인 경우 최댓값 1로 설정
                if (books.isEmpty()) {
                    maxTitle = title;
                    maxCount = 1;
                }
                // 현재 팔린 최댓값이 1인 경우 사전순 확인
                else if (maxCount == 1) {
                    String[] temp = {title, maxTitle};
                    Arrays.sort(temp);
                    maxTitle = temp[0];
                }
                // 맵에 추가
                books.put(title, 1);
            }
            // 팔린적 있는 책인 경우
            else {
                // 현재 팔린 최댓값이 동일한 경우 사전순 확인
                if (books.get(title) + 1 == maxCount) {
                    String[] temp = {title, maxTitle};
                    Arrays.sort(temp);
                    maxTitle = temp[0];
                }
                // 현재 팔린 최댓값이 지금 팔린 책의 권수보다 더 작은 경우 갱신
                else if (books.get(title) + 1 > maxCount){
                    maxCount = books.get(title) + 1;
                    maxTitle = title;
                }
                // 책의 팔린 권수 갱신
                books.put(title, books.get(title) + 1);
            }
        }
        return maxTitle;    // 가장 많이 팔린 책 제목 리턴
    }
}
