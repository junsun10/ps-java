// 스위치 켜고 끄기 ( 정답 )
// 알고리즘: 구현, 시뮬레이션

package boj.simulation;

import java.io.*;
import java.util.*;

public class S4_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            int c;
            // 남자인 경우
            if (s == 1) {
                // 배수 상태 변경
                for (int j = 1; j < n+1; j++) {
                    if (j / value >= 1 && j % value == 0) {
                        if (arr[j] == 0) {
                            arr[j] = 1;
                        }
                        else {
                            arr[j] = 0;
                        }
                    }
                }
            }
            // 여자인 경우
            else {
                // 좌우 대팅이면서 가장 많은 스위치를 포함하는 구간 계산
                // 양옆으로 c 만큼까지 상태 변경
                c = 0;
                for (int j = 1; j < n+1; j++) {
                    if (value-c-1 >= 1 && value+c+1 < n+1){
                        if (arr[value-c-1] == arr[value+c+1]) {
                            c += 1;
                        }
                        else {
                            break;
                        }
                    }
                }
                if (c == 0) {
                    if (arr[value] == 0) {
                        arr[value] = 1;
                    }
                    else {
                        arr[value] = 0;
                    }
                }
                else {
                    if (arr[value] == 0) {
                        arr[value] = 1;
                    }
                    else {
                        arr[value] = 0;
                    }
                    for (int j = 1; j < c+1; j++) {
                        if (arr[value+j] == 0) {
                            arr[value+j] = 1;
                        }
                        else {
                            arr[value+j] = 0;
                        }

                        if (arr[value-j] == 0) {
                            arr[value-j] = 1;
                        }
                        else {
                            arr[value-j] = 0;
                        }
                    }
                }
            }
        }
        // 형식에 맞게 출력
        for (int i = 1; i < n+1; i++) {
            System.out.print(arr[i]+" ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
