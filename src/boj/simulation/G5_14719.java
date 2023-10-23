// 빗물 ( 정답 )
// 알고리즘: 구현, 시뮬레이션
// 물의 높이를 1씩 증가시키면서 고일 수 있는지 계산

package boj.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14719 {
    public static int h;    // 세로 길이
    public static int w;    // 가로 길이
    public static int[] arr;    // 블록 높이 배열
    public static int answer = 0;   // 정답 저장

    public static void main(String[] args) throws Exception {
        read(); // 문제 입력
        solution(); // 정답 계산
        System.out.println(answer);
    }

    // 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[w];   // 블록 배열 초기화

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    // 풀이 함수
    public static void solution() {
        // 높이를 1부터 h까지 높이면서 물이 고이는지 확인
        for (int i = 1; i < h+1; i++) {
            boolean check = false;  // 왼쪽이 막혔는지 여부
            int temp = 0;   // 오른쪽이 막힌것을 확인할 때 까지 임시 저장
            for (int j = 0; j < w; j++) {   // 0번째 인덱스부터 진행
                if (!check && arr[j] >= i) {    // 왼쪽이 막힌 지점 확인
                    check = true;
                }
                if (check) {    // 왼쪽이 막힌 상태
                    if (arr[j] >= i) {  // 오른쪽이 막힌 지점
                        answer += temp; // 오른쪽이 막혔으므로 정답에 더함
                        temp = 0;   // temp 초기화
                    }
                    else {
                        temp += 1;  // 현재 물 높이보다 낮으면 1 증가
                    }
                }
                // 이 위치에서 temp를 한번에 answer에 더하지 않는 이유는
                // 만약 for문이 끝날때 오른쪽이 막혀있지 않으면 고일 수 없기 때문
                // 따라서 i와 높이가 크거나 같은 지점을 만날 때마다 answer에 더하고 초기화
            }
        }
    }
}
