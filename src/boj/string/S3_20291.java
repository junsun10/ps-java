// 파일 정리 ( 정답 )
// 알고리즘: 문자열, 맵

package boj.string;

import java.io.*;
import java.util.*;

public class S3_20291 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(); // HashMap을 사용하여 확장자 카운트

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(),".");
            st.nextToken();
            String type = st.nextToken();

            if (map.containsKey(type)) {
                map.put(type, map.get(type)+1);
            }
            else {
                map.put(type, 1);
            }
        }

        ArrayList<String> arr = new ArrayList<>();  // 확장자 이름만 저장
        for(String key: map.keySet()) {
            arr.add(key);
        }

        Collections.sort(arr);  // 사전순 정렬

        for (String name : arr) {
            bw.write(name+" "+map.get(name)+"\n"); // 결과 출력
        }
        bw.flush();
    }
}
