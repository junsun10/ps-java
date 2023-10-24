// 햄버거 문제 ( 정답 )
// 알고리즘: 그리디
// 앞에서부터 사람이 먹을 수 있는 햄버거가 범위 내에 있는지 확인

package boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_19941 {
    public static int n, k;     // n: 식탁의 길이, k: 햄버거를 선택할 수 있는 거리
    public static int[][] arr;    // 식탁 상태 배열

    public static void main(String[] args) throws Exception {
        read(); // 문제 입력
        System.out.println(solution()); // 풀이 및 출력
    }

    // 문제 입력 함수
    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());   // 식탁의 길이 할당
        k = Integer.parseInt(st.nextToken());   // 햄버거를 선택할 수 있는 거리 할당
        arr = new int[n][2];    // {0,0}: {사람,}, {1,1}: {햄버거, 선택됨}, {1,0}: {햄버거, 선택 안됨}

        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'H') {   // 햄버거이면 1
                arr[i][0] = 1;
            }
            else {  // 사람이면 0
                arr[i][0] = 0;
            }
        }
    }

    // 풀이 함수
    public static int solution() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {   // 사람인 경우
                // 배열 범위에 벗어나지 않게 i 기준으로 왼쪽 오른쪽 k만큼 탐색
                // 선택 안된 햄버거가 있는 경우 answer를 증가한 뒤 햄버거 상태를 선택됨으로 갱신
                if (i - k < 0 && i + k > n - 1) {
                    for (int j = 0; j < n; j++) {
                        if (arr[j][0] == 1 && arr[j][1] == 0) { // 햄버거이고 선택되지 않은 경우
                            answer += 1;    // 정답 증가
                            arr[j][1] = 1;  // 선택됨으로 갱신
                            break;
                        }
                    }
                }
                else if (i - k < 0) {
                    for (int j = 0; j < i + k + 1; j++) {
                        if (arr[j][0] == 1 && arr[j][1] == 0) {
                            answer += 1;
                            arr[j][1] = 1;
                            break;
                        }
                    }
                }
                else if (i + k > n - 1) {
                    for (int j = i - k; j < n; j++) {
                        if (arr[j][0] == 1 && arr[j][1] == 0) {
                            answer += 1;
                            arr[j][1] = 1;
                            break;
                        }
                    }
                }
                else {
                    for (int j = i - k; j < i + k + 1; j++) {
                        if (arr[j][0] == 1 && arr[j][1] == 0) {
                            answer += 1;
                            arr[j][1] = 1;
                            break;
                        }
                    }
                }
            }
        }
        return answer;  // 정답 리턴
    }
}
