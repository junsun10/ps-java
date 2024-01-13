// 감소하는 수 ( 정답 )
// 알고리즘: 브루트포스

package boj.bruteforcing;

import java.io.*;

public class G5_1038 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() {
        int count = -1;
        long value = 0;
        while (true) {
            if (value > 987654321) {    // 더이상 증가할 수 없음
                if (count+1 == n) {
                    System.out.printf("9876543210");
                }
                else {
                    System.out.println(-1);
                }
                break;
            }
            if (check(value)) { // 감소하는 수 확인
                count += 1;
                if (count == n) {
                    System.out.println(value);
                    break;
                }
                value += 1;
            }
            else {  // 감소하지 않으면 10의 자리수 증가
                value = value - value%10 + 10;
            }
        }
    }

    static boolean check(long v) {
        if (v < 10) {
            return true;
        }

        boolean available = true;
        while (v >= 10) {
            if (v%10 >= v/10%10) {
                available = false;
                break;
            }
            else {
                v = v/10;
            }
        }
        return available;
    }
}
