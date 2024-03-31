// 피터팬 프레임 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S5_3054 {

    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        solution();
    }

    static void solution() {
        firstLine();
        secondLine();
        thirdLine();
        secondLine();
        firstLine();
    }

    static void firstLine() {
        String temp= "..";
        for (int i = 0; i < input.length(); i++) {
            if (i == input.length()-1) {
                if ((i+1) % 3 == 0) {
                    temp += "*..";
                }
                else {
                    temp += "#..";
                }
            }
            else {
                if ((i+1) % 3 == 0) {
                    temp += "*...";
                } else {
                    temp += "#...";
                }
            }
        }
        System.out.println(temp);
    }

    static void secondLine() {
        String temp= ".";
        for (int i = 0; i < input.length(); i++) {
            if ((i+1) % 3 == 0) {
                temp += "*.*.";
            }
            else {
                temp += "#.#.";
            }

        }
        System.out.println(temp);
    }

    static void thirdLine() {
        String temp= "";
        for (int i = 0; i < input.length(); i++) {
            if (i == input.length()-1) {
                if ((i+1) % 3 == 0) {
                    temp += "*." + input.charAt(i) + ".*";
                }
                else if ((i+1) % 3 == 1 & i>0) {
                    temp += "*." + input.charAt(i) + ".#";
                }
                else {
                    temp += "#." + input.charAt(i) + ".#";
                }
            }
            else {
                if ((i+1) % 3 == 0) {
                    temp += "*." + input.charAt(i) + ".";
                }
                else if ((i+1) % 3 == 1 & i>0) {
                    temp += "*." + input.charAt(i) + ".";
                }
                else {
                    temp += "#." + input.charAt(i) + ".";
                }
            }
        }
        System.out.println(temp);
    }
}
