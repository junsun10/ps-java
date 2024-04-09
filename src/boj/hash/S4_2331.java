// 반복수열 ( 정답 )
// 알고리즘: 맵

package boj.hash;

import java.io.*;
import java.util.*;

public class S4_2331 {

    static int a, b;
    static HashMap<Integer, Integer> valueMap = new HashMap<>();
    static HashMap<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        int index = 0;

        valueMap.put(a, index);
        indexMap.put(index, a);
        index += 1;

        while (true) {
            int x = indexMap.get(index-1);
            int value = 0;
            while (x > 0) {
                value += Math.pow(x%10,b);
                x /= 10;
            }

            if (valueMap.containsKey(value)) {
                System.out.println(valueMap.get(value));
                break;
            }
            else {
                valueMap.put(value, index);
                indexMap.put(index, value);
                index += 1;
            }
        }
    }
}
