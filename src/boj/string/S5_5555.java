// 반지 ( 정답 )
// 알고리즘: 문자열, 브루트포스

package boj.string;

import java.io.*;

public class S5_5555 {

    static String word;
    static int n;
    static String[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        solution();
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + arr[i].substring(0, word.length() - 1);
            for (int j = 0; j <= arr[i].length() - word.length(); j++) {
                if (arr[i].substring(j, j + word.length()).equals(word)) {
                    answer += 1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
