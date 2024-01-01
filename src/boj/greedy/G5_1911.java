// 흙길 보수하기 ( 정답 )
// 알고리즘: 그리디, 정렬

package boj.greedy;

import java.io.*;
import java.util.*;

public class G5_1911 {
    static int n, l;        // n: 웅덩이 개수, l: 널빤지 길이
    static long[][] waters; // 웅덩이의 좌표 저장 배열
    static int answer = 0;  // 필요한 널빤지 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        waters = new long[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long[] temp = new long[2];
            temp[0] = Long.parseLong(st.nextToken());
            temp[1] = Long.parseLong(st.nextToken());
            waters[i] = temp.clone();
        }

        solution();
    }

    static void solution() {
        // 웅덩이 시작 좌표를 기준으로 정렬
        Arrays.sort(waters, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o1[0] - o2[0]);
            }
        });

        long index = 0;                 // 널빤지가 끝나는 위치
        for (long[] water : waters) {   // 모든 웅덩이
            if (index < water[0]) {     // 널빤지가 끝나는 위치가 웅덩이 시작점 보다 작으면
                index = water[0];       // 웅덩이 시작점으로 이동
            }
            while (index < water[1]) {  // 널빤지가 끝나는 위치를 웅덩이 끝점 보다 커질 때 까지 증가
                index += l;
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
