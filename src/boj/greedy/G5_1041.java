// 주사위 ( 정답 )
// 알고리즘: 그리디, 수학

package boj.greedy;

import java.io.*;
import java.util.*;

public class G5_1041 {
    static long n;          // 정육면체 한 변 길이
    static int top, bottom; // 주사위 위, 아래
    static int[] side = new int[4];         // 주사위 옆면
    static long one = Integer.MAX_VALUE;    // 한 면의 최솟값
    static long two = Integer.MAX_VALUE;    // 두 면의 합 최솟값
    static long three = Integer.MAX_VALUE;  // 세 면의 합 최솟값
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // n, 주사위 입력
        n = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        top = Integer.parseInt(st.nextToken());
        side[0] = Integer.parseInt(st.nextToken());
        side[1] = Integer.parseInt(st.nextToken());
        side[3] = Integer.parseInt(st.nextToken());
        side[2] = Integer.parseInt(st.nextToken());
        bottom = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        getOne();
        getTwo();
        getThree();
        getAnswer();
        System.out.println(answer);
    }

    // 한 면의 최솟값 구하는 함수
    static void getOne() {
        one = Math.min(top, one);
        one = Math.min(bottom, one);
        for (int i = 0; i < 4; i++) {
            one = Math.min(side[i], one);
        }
    }

    // 두 면의 합 최솟값 구하는 함수
    static void getTwo() {
        for (int i = 0; i < 4; i++) {
            two = Math.min(top + side[i], two);
        }
        for (int i = 0; i < 4; i++) {
            two = Math.min(bottom + side[i], two);
        }
        two = Math.min(side[0]+side[3], two);
        for (int i = 0; i < 3; i++) {
            two = Math.min(side[i]+side[i+1], two);
        }
    }

    // 세 면의 합 최솟값 구하는 함수
    static void getThree() {
        three = Math.min(top + side[0] + side[3], three);
        for (int i = 0; i < 3; i++) {
            three = Math.min(top + side[i] + side[i+1], three);
        }
        three = Math.min(bottom + side[0] + side[3], three);
        for (int i = 0; i < 3; i++) {
            three = Math.min(bottom + side[i] + side[i+1], three);
        }
    }

    // 정답 구하는 함수
    static void getAnswer() {
        if (n == 1) {   // n == 1인 경우 주사위 하나로 이루어짐
            int sum = top + bottom;
            int max = Math.max(top, bottom);
            for (int i = 0; i < 4; i++) {
                max = Math.max(side[i], max);
                sum += side[i];
            }
            answer = sum - max;
        }
        else {
            answer += ((n-2)*4*(n-1) + (n-2)*(n-2)) * one;  // 한 면이 보이는 경우
            answer += (4*(n-1) + (n-2)*4) * two;            // 두 면이 보이는 경우
            answer += 4 * three;                            // 세 면이 보이는 경우
        }
    }
}
