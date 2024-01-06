// 기타줄 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;
import java.util.*;

public class S4_1049 {
    static int n, m;    // n: 끈어진 기타줄 수, m: 기타줄 브랜드 수
    static int[] pack;  // 6줄 패키지 가격
    static int[] one;   // 낱개 가격

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pack = new int[m];
        one = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pack[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    static void solution() {
        Arrays.sort(pack);
        Arrays.sort(one);

        if (pack[0] > one[0]*6) {           // 가장 싼 패키지 가격이 가장 싼 낱개 6개 보다 비싼 경우
            System.out.println(one[0]*n);   // 낱개로만 구매
        }
        else {  // n개를 맞춰서 사는 경우와 패키지만으로 넘치게 사는 경우 비교
            System.out.println(Math.min((pack[0]*(n/6)+one[0]*(n%6)), pack[0]*(n/6 + 1)));
        }
    }
}
