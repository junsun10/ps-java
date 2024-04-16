// 숫자놀이 ( 정답 )
// 알고리즘: 문자열, 정렬

package boj.string;

import java.io.*;
import java.util.*;

public class S4_1755 {

    static int n, m;
    static Num[] arr;
    static HashMap<Integer, String> map = new HashMap<>();

    public static class Num {
        int val;
        String name;

        public Num(int n) {
            this.val = n;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Num[m-n+1];

        solution();
    }

    static void solution() {

        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        for (int i = 0; i <= m-n; i++) {

            Num x = new Num(i + n);

            String name = "";
            int num = i + n;

            while (num > 0) {
                if (num == i + n) {
                    name = map.get(num % 10);
                }
                else {
                    name = map.get(num % 10) + " " + name;
                }
                num /= 10;
            }
            x.name = name;
            arr[i] = x;
        }

        Arrays.sort(arr, new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i].val);
            if (i%10 == 9) {
                System.out.println();
            }
        }
    }
}
