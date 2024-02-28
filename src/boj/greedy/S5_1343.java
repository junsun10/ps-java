// 폴리노미오 ( 정답 )
// 알고리즘: 그리디

package boj.greedy;

import java.io.*;

public class S5_1343 {

    static String str;
    static String answer = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        solution();
    }

    static void solution() {
        boolean end = false;
        int start = 0;
        while (start < str.length()) {
            if (start + 3 < str.length()){
                if (str.substring(start, start+4).equals("XXXX")) {
                    answer += "AAAA";
                    start += 4;
                }
                else if (str.substring(start, start + 2).equals("XX")) {
                    answer += "BB";
                    start += 2;
                }
                else {
                    if (str.charAt(start) == '.') {
                        answer += ".";
                        start += 1;
                    }
                    else {
                        System.out.println(-1);
                        end = true;
                        break;
                    }
                }
            }
            else if (start + 1 < str.length()) {
                if (str.substring(start, start + 2).equals("XX")) {
                    answer += "BB";
                    start += 2;
                }
                else {
                    if (str.charAt(start) == '.') {
                        answer += ".";
                        start += 1;
                    }
                    else {
                        System.out.println(-1);
                        end = true;
                        break;
                    }
                }
            }
            else {
                if (str.charAt(start) == '.') {
                    answer += ".";
                    start += 1;
                }
                else {
                    System.out.println(-1);
                    end = true;
                    break;
                }
            }
        }

        if (!end) {
            System.out.println(answer);
        }
    }
}
