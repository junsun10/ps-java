// 오큰수 ( 정답 )
// 알고리즘: 스택

package boj.stack;

import java.io.*;
import java.util.*;

public class G4_17298 {
    static int n;           // 수열의 길이
    static int[] arr;       // 수열
    static int[] answer;    // 오큰수
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {  // 오큰수 -1로 초기화
            answer[i] = -1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        // 오큰수 출력
        for (int i=1; i <= n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }

    static void solution() {
        dq.add(new int[] {arr[1], 1});          // 스택에 첫번째 값과 인덱스 추가

        for (int i = 2; i <= n; i++) {          // 두번째 부터 n까지
            while (!dq.isEmpty()) {             // 스택이 비어있지 않고
                int[] top = dq.peek();
                if (arr[i] > top[0]) {          // 스택의 탑 값이 arr[i]보다 작으면
                    answer[top[1]] = arr[i];    // 오큰수 저장
                    dq.pop();                   // pop
                }
                else {                          // 크거나 같으면
                    break;                      // 스택의 아래 값들은 탑보다 무조건 크거나 같으므로 탈출
                }
            }
            dq.push(new int[] {arr[i], i});     // arr[i] 스택에 추가
        }


    }
}
