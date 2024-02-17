// 종이자르기 ( 정답 )
// 알고리즘: 구현, 정렬

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S5_2628 {

    static int w, h, t;
    static ArrayList<Integer> arrW = new ArrayList<>();
    static ArrayList<Integer> arrH = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.nextToken().equals("1")) {
                arrW.add(Integer.parseInt(st.nextToken()));
            }
            else {
                arrH.add(Integer.parseInt(st.nextToken()));
            }
        }

        solution();
    }

    static void solution() {
        Collections.sort(arrW);
        Collections.sort(arrH);

        int maxW = 0;
        int start = 0;
        for (Integer i : arrW) {
            if (i - start > maxW) {
                maxW = i - start;
            }
            start = i;
        }
        maxW = Math.max(maxW, (w - start));

        int maxH = 0;
        start = 0;
        for (Integer i : arrH) {
            if (i - start > maxH) {
                maxH = i - start;
            }
            start = i;
        }
        maxH = Math.max(maxH, (h - start));

        System.out.println(maxW * maxH);
    }
}
