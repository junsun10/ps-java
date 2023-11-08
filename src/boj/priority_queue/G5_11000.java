// 강의실 배정 ( 정답 )
// 알고리즘: 우선순위 큐, 정렬, 그리디

package boj.priority_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class G5_11000 {
    public static int n;    // 수업의 개수
    public static int[][] classes;    // 수업 정보 저장 배열
    public static PriorityQueue<Integer> heap = new PriorityQueue<>();  // 수업중인 강의실
    public static int count = 0;    // 총 강의실 수

    public static void main(String[] args) throws Exception {
        read();     // 입력 함수
        solution(); // 풀이 함수
        System.out.println(count);  // 정답 출력
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 수업의 개수 입력
        classes = new int[n][2];                // 수업 정보 저장 배열 초기화 [시작 시간, 종료 시간]
        // 수업 정보 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            classes[i] = new int[] {s,t};
        }
    }

    // 풀이 함수
    // 수업 정보를 정렬한 뒤 우선순위 큐를 사용해
    // 종료 시간이 가장 빠른 강의실에서 다음 수업을 할 수 있는 지 판단
    public static void solution() {
        // 수업 정보 오름차순 정렬
        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 시작 시간이 같은 경우 종료 시간 기준 오름차순 정렬
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        // 모든 수업 방문
        for (int i = 0; i < n; i++) {
            int start = classes[i][0];
            int end = classes[i][1];

            // 강의실이 없으면 추가 (첫 수업일때)
            if (heap.isEmpty()) {
                heap.add(end);
            }
            else {
                int temp = heap.remove();   // 현재 수업중인 강의실에서 가장 빨리 끝나는 시간
                // 다음 수업 시작 시간과 비교
                if (start >= temp) {        // 다음 수업 시작 시간이 가장 빨리 끝나는 시간보다 작거나 같으면
                    heap.add(end);          // 기존 강의실에서 수업 가능
                }
                else {                      // 다음 수업 시작 시간이 가장 빨리 끝나는 시간보다 빠르면
                    heap.add(temp);         // 기존 수업을 다시 저장
                    heap.add(end);          // 새로운 강의실에 추가
                }
            }
        }
        count = heap.size();    // 마지막 수업이 시작한 시점에서 수업중인 강의실의 수가 정답
    }
}