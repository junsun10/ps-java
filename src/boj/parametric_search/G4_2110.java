// 공유기 설치 ( 정답 )
// 알고리즘: 매개 변수 탐색

package boj.parametric_search;

import java.io.*;
import java.util.*;

public class G4_2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, c;    // n: 집의 개수, c: 공유기 개수
    static int[] arr;   // 집의 좌표

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static void read() throws Exception {
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solution() {
        Arrays.sort(arr);

        // 가장 인접한 두 공유기 사이 거리의 최댓값을 매개 변수 탐색을 통해 구함
        int start = 0;
        int end = 1000000000;
        int answer = 0;
        while (start <= end) {
            int mid = (start+end)/2;    // 가장 인접한 두 공유기 사이의 거리 선택
            if (available(mid)){        // 공유기 c개를 모두 설치 가능한지 확인
                answer = mid;
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }

    // 가장 인접한 두 공유기 사이의 거리 d로 c개의 공유기를 모두 설치할 수 있는지 확인
    static boolean available(int d) {
        int count = 1;
        int beforeX = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - beforeX >= d) {    // 현재 집에 설치 가능
                count += 1;
                beforeX = arr[i];
            }
        }
        return count >= c;
    }
}
