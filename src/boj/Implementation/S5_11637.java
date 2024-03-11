// 인기 투표 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;

public class S5_11637 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            int total = 0;
            int max = 0;
            int index = -1;

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(br.readLine());
                total += arr[j];
                if (arr[j] > max) {
                    max = arr[j];
                    index = j+1;
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == max) {
                    count += 1;
                }
            }

            if (count > 1) {
                System.out.println("no winner");
            }
            else {
                if (total % 2 == 0) {
                    if (max > total / 2) {
                        System.out.printf("majority winner %d\n", index);
                    }
                    else {
                        System.out.printf("minority winner %d\n", index);
                    }
                }
                else {
                    if (max >= total / 2) {
                        System.out.printf("majority winner %d\n", index);
                    }
                    else {
                        System.out.printf("minority winner %d\n", index);
                    }
                }
            }
        }
    }
}
