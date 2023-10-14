// 올림픽 ( 정답 )
// 알고리즘: 구현, 정렬
// Nation 클래스를 생성, 정렬을 위한 오버라이딩

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_8979 {
    static class Nation implements Comparable<Nation> {
        int g,s,b,index;

        Nation (int g, int s, int b, int index) {
            this.g = g;
            this.s = s;
            this.b = b;
            this.index = index;
        }

        @Override
        public int compareTo(Nation x) {
            if (this.g > x.g) {
                return -1;
            }
            else if (this.g < x.g) {
                return 1;
            }
            else {
                if (this.s > x.s) {
                    return -1;
                }
                else if (this.s < x.s) {
                    return 1;
                }
                else{
                    if (this.b > x.b) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Nation> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Nation(g,s,b,index));
        }
        Collections.sort(arr);

        int rank = 1;
        if (m == arr.get(0).index) {
            System.out.println(rank);
        }
        else {
            for (int i = 1; i < n; i++) {

                if (!(arr.get(i).g == arr.get(i - 1).g && arr.get(i).s == arr.get(i - 1).s && arr.get(i).b == arr.get(i - 1).b)) {
                    rank = i + 1;
                }

                if (arr.get(i).index == m) {
                    break;
                }

            }
            System.out.println(rank);
        }
    }
}