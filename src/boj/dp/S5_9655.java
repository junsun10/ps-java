// 돌 게임 ( 정답 )
// 알고리즘: dp

package boj.dp;

import java.io.*;
import java.util.*;

public class S5_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Boolean> dp = new ArrayList<>();

        dp.add(true);
        dp.add(true);
        dp.add(false);
        dp.add(true);
        dp.add(false);


        for (int i = 5; i < n+1; i++) {
           if (dp.get(i-1) || dp.get(i-3)) {
               dp.add(false);
           }
           else {
               dp.add(true);
           }
        }

        if (dp.get(n)) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }

    }
}
