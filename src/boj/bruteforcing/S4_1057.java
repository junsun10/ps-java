// 토너먼트 ( 정답 )
// 알고리즘: 브루트포

package boj.bruteforcing;

import java.io.*;
import java.util.*;

public class S4_1057 {
    static int n;
    static int a, b;
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        solution();
    }

    static void solution() {
        int t = n;
        while (true) {
            if ((a-b == 1 & a%2 == 0) | (b-a == 1 & b%2 == 0)) {    // 이번 라운드에서 만나는 경우
                break;
            }
            else {  // 번호 갱신
                if (a%2 == 0) {
                    a /= 2;
                }
                else {
                    if (a == n) {
                        a = n/2 + 1;
                    }
                    else {
                        a = (a+1)/2;
                    }
                }
                if (b%2 == 0) {
                    b /= 2;
                }
                else {
                    if (b == n) {
                        b = n/2 + 1;
                    }
                    else {
                        b = (b+1)/2;
                    }
                }
            }
            // 라운드 인원 갱신
            if (t%2 == 0) {
                t /= 2;
            }
            else {
                t = (t-1)/2 + 1;
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}
