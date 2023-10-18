// 어두운 굴다리 ( 정답 )
// 알고리즘: 구현
// 가로등 사이 최대 거리와 양 끝 거리를 구해 계산했지만 이분탐색도 가능

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S4_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 굴다리 길이
        int m = Integer.parseInt(br.readLine());    // 가로등 개수

        st = new StringTokenizer(br.readLine()," ");
        int maxDistance = -1;   // 최대 사이 거리
        int firstPoint = Integer.parseInt(st.nextToken());  // 첫번째 가로등 위치
        int lastPoint = n;  // 마지막 가로등 위치
        int before = firstPoint; // 이전 가로등 위치

        // 가로등이 한개이면 아래 for문에서 lastPoint 할당이 안됨
        if (m == 1) {
            lastPoint = firstPoint;
        }

        // 가로등 사이 최대 거리 계산
        for (int i = 1; i < m; i++) {
            int index = Integer.parseInt(st.nextToken());
            // 최대값 갱신
            if (index - before > maxDistance) {
                maxDistance = index - before;
            }
            if (i == m-1) {
                lastPoint = index;
            }
            before = index;
        }

        // 가능한 최소 높이 계산
        int answer;
        if (maxDistance % 2 == 0) {
            answer = maxDistance / 2;
        }
        else {
            answer = maxDistance / 2 + 1;
        }

        // 양 끝은 따로 계산
        int[] temp = {firstPoint, n-lastPoint, answer};
        System.out.println(Arrays.stream(temp).max().getAsInt());
    }
}
