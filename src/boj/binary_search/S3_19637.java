// IF문 좀 대신 써줘 ( 정답 )
// 알고리즘: 이분 탐색

package boj.binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S3_19637 {
    public static int n,m;  // n: 칭호의 개수, m: 캐릭터들의 개수
    public static ArrayList<String> names = new ArrayList<>();      // 칭호 이름 리스트
    public static ArrayList<Integer> scores = new ArrayList<>();    // 전투력 상한값 리스트
    public static HashMap<Integer, Boolean> map = new HashMap<>();  // 전투력 중복 확인을 위한 맵

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());   // 칭호 개수 입력
        m = Integer.parseInt(st.nextToken());   // 캐릭터들 개수 입력

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (!map.containsKey(value)) {  // 전투력 중복 확인
                map.put(value, true);
                names.add(name);
                scores.add(value);
            }
        }

        for (int i = 0; i < m; i++) {
            int score = Integer.parseInt(br.readLine());
            int index = search(score);  // 칭호 인덱스
            bw.write(names.get(index)+"\n");
        }
        bw.flush();
    }

    // 이분 탐색
    public static int search(int score) {
        int start = 0;
        int end = scores.size()-1;
        int mid = (start + end) / 2;
        while (start < end) {
            mid = (start + end) / 2;
            if (score > scores.get(mid)) {
                start = mid + 1;
            }
            else if (score < scores.get(mid)) {
                end = mid;
            }
            else {
                break;
            }
        }
        if (score > scores.get(mid)){
            return mid+1;
        }
        return mid;
    }
}
