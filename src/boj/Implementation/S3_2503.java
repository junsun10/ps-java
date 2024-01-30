// 숫자 야구 ( 정답 )
// 알고리즘: 구현, 브루트포스

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S3_2503 {

    static int n;
    static List<int[]> arr = new ArrayList<>();
    static int[] balls = new int[4];    // 마지막 인덱스는 조건을 만족한 경우의 수
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        getAll(0);  // 숫자야구 모든 경우의 수 만들기

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int temp = Integer.parseInt(st.nextToken());
            int c = temp%10;
            temp /= 10;
            int b = temp%10;
            temp /= 10;
            int a = temp;

            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            solution(a, b, c, strike, ball);
        }

        countAnswer();
    }
    
    static void getAll(int count) {
        if (count == 3) {
            arr.add(balls.clone());
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                balls[count] = i;
                visited[i] = true;
                getAll(count + 1);
                visited[i] = false;
            }
        }
    }

    static void solution(int a, int b, int c, int strike, int ball) {
        // 모든 경우의 수에서 조건을 만족하는 경우 찾기
        for (int[] ints : arr) {
            int countStrike = 0;
            int countBall = 0;
            if (ints[0] == a) {
                countStrike += 1;
            }
            else if (ints[0] == b | ints[0] == c) {
                countBall += 1;
            }

            if (ints[1] == b) {
                countStrike += 1;
            }
            else if (ints[1] == a | ints[1] == c) {
                countBall += 1;
            }

            if (ints[2] == c) {
                countStrike += 1;
            }
            else if (ints[2] == a | ints[2] == b) {
                countBall += 1;
            }

            // 조건을 만족하는 경우 count 증가
            if (countStrike == strike & countBall == ball) {
                ints[3] += 1;
            }
        }
    }

    static void countAnswer() {
        int answer = 0;
        for (int[] ints : arr) {
            if (ints[3] == n) { // 모든 조건을 만족한 경우의 수 세기
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
