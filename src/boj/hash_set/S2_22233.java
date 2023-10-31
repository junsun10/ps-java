// 가희와 키워드 ( 정답 )
// 알고리즘: 맵, 문자열
// 키워드들을 맵에 저장해 검색하는 시간을 줄임

package boj.hash_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S2_22233 {
    public static int n, m;     // n: 메모장에 적은 키워드 개수, m: 블로그에 쓴 글의 개수
    public static HashMap<String, Integer> map = new HashMap<>();   // 메모장에 적은 키워드 상태 저장

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        read();     // 입력 함수
        solution(); // 풀이 함수
        bw.flush(); // 정답 출력
    }

    // 입력 함수
    public static void read() throws Exception {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // HashMap에 (키워드,1)로 추가
        for (int i = 0; i < n; i++) {
            String keyWord = br.readLine();
            map.put(keyWord, 1);
        }
    }

    public static void solution() throws Exception {
        // 블로그에 쓴 횟수만큼 진행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            int lenToken = st.countTokens();    // 블로그에 쓴 키워드 개수 저장
            String keyWord;
            // 블로그에 쓴 키워드 개수만큼 진행
            for (int j = 0; j < lenToken; j++) {
                keyWord = st.nextToken();   // 쓴 키워드 저장

                if (map.containsKey(keyWord)) {     // 키워드가 map에 존재하고
                    if (map.get(keyWord) == 1) {    // 값이 1이면 사용하지 않았으므로
                        map.put(keyWord, 0);        // 값을 0으로 변경한 뒤
                        n -= 1;                     // 미사용 키워드 개수 갱신
                    }
                }
            }
            bw.write(n+"\n");   // 각 글을 쓴 뒤 미사용 키워드 개수 저장
        }
    }
}
