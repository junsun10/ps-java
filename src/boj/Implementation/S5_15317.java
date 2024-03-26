// 이름 궁합 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S5_15317 {

    static String a, b;
    static int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();

        solution();
    }

    static void solution() {
        String name = "";
        for (int i = 0; i < a.length(); i++) {
            name += a.charAt(i);
            name += b.charAt(i);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            arr.add(count[name.charAt(i) - 'A']);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        while (true) {
            if (arr.size() == 2) {
                System.out.printf("%d%d\n", arr.get(0), arr.get(1));
                break;
            }

            temp.clear();
            for (int i = 0; i < arr.size()-1; i++) {
                temp.add((arr.get(i) + arr.get(i+1)) % 10);
            }
            arr = new ArrayList<>(temp);
        }
    }
}
