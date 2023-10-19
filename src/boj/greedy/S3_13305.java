// 주유소 ( 정답 )
// 알고리즘: 그리디
// 도시 사이의 거리와 리터당 가격의 최댓값이 10억이므로 long 사용

package boj.greedy;

import java.io.*;
import java.util.*;

public class S3_13305 {
    static int n;   // 도시의 개수
    static long[] distance;   // 도로의 길이
    static long[] price;    // 리터당 기름값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 개수 입력
        n = Integer.parseInt(br.readLine());
        distance = new long[n-1];
        price = new long[n];

        // 도로의 길이 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        // 리터당 기름값 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = price[0];    // 지금까지 기름값의 최솟값, 시작은 첫번째 도시의 기름값
        long totalPrice = price[0]*distance[0];  // 총 비용, 첫번째 도시에서 두번째 도시까지 이동은 미리 계산
        for (int i = 1; i < n-1; i++) { // 두번째 도시부터 계산
            if (price[i] < minPrice) {  // 최솟값보다 기름값이 싸면 갱신
                minPrice = price[i];
                totalPrice += price[i]*distance[i];
            }
            else {  // 최솟값으로 계산
                totalPrice += minPrice*distance[i];
            }
        }
        System.out.println(totalPrice);
    }
}
