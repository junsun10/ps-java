// 숫자의 개수
// 알고리즘: 수학, 구현

package boj.math;

import java.io.*;
import java.util.*;
public class B2_2577 {
    public static int[] arr = new int[3];   // A,B,C 저장

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void solution() {
        int total = 1;  // A*B*C 저장
        for (int i = 0; i < 3; i++) {
            total *= arr[i];
        }

        // 각 자리 숫자 개수 0으로 초기화
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i,0);
        }
        // 각 자리 숫자 카운트
        int temp = 0;
        while (total > 0) {
            temp = total%10;
            map.put(temp, map.get(temp)+1);
            total /= 10;
        }
        // 출력
        for (int i = 0; i < 10; i++) {
            System.out.println(map.get(i));
        }
    }
}
