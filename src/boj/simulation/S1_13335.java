// 트럭 ( 정답 )
// 알고리즘: 큐, 시뮬레이션

package boj.simulation;

import java.io.*;
import java.util.*;

public class S1_13335 {
    static int n, w, l; //n: 트럭 수, w: 다리 길이, l: 최대 하중
    static int[] arr;   // 트럭 무게
    static Deque<int[]> dq = new ArrayDeque<>();    // 다리 위의 트럭 상태

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        int nowWeight = arr[0]; // 현재 다리 위의 트럭 무게 합
        int time = 1;           // 지난 시간
        int index = 1;          // 다음에 올라갈 트럭 위치
        dq.add(new int[]{arr[0], 1});   // 첫번째 트럭 올림

        while (!dq.isEmpty()) { // 트럭이 모두 지나갈 때 까지
            time += 1;
            int len = dq.size();
            for (int i = 0; i < len; i++) { // dp 길이만큼 반복
                int[] truck = dq.pop();
                if (truck[1] == w) {        // 트럭이 다리를 모두 건넌 경우
                    nowWeight -= truck[0];  // 무게 감소
                }
                else {                      // 아직 못 건넌 경우
                    dq.add(new int[]{truck[0], truck[1] + 1});  // 위치 + 1
                }
            }
            if (index < n) {
                if (nowWeight + arr[index] <= l) {  // 새로운 트럭을 올릴 수 있는 경우 추가
                    dq.add(new int[]{arr[index], 1});
                    nowWeight += arr[index];
                    index += 1;
                }
            }
        }
        System.out.println(time);
    }
}
