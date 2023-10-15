// 비밀번호 발음하기 ( 정답 )
// 알고리즘: 구현, 문자열

package boj.string;

import java.io.*;
import java.util.*;

public class S5_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> must = new ArrayList<>();
        must.add("a");
        must.add("e");
        must.add("i");
        must.add("o");
        must.add("u");

        while (true) {
            String str = br.readLine();


            if (str.equals("end")) {
                break;
            }

            Boolean acceptable = true;

            // 모음 포함 확인
            Boolean check1 = false;
            // 자음 모음 연속 확인
            int count = 1;
            // 이전 글자 자음: false, 모음: true
            Boolean check2 = false;
            // 연속 글자 확인
            String before = Character.toString(str.charAt(0));
            int beforeCount = 0;

            String now;

            for (int i = 0; i < str.length(); i++) {
                System.out.printf("%b, %b, %s, %d, %d\n",check1, check2, before, count, beforeCount);
                if (i == 0) {
                    now = Character.toString(str.charAt(i));
                    if (must.contains(now)) {
                        check1 = true;
                        check2 = true;
                        if (now.equals("e") || now.equals("o")) {
                            beforeCount = 1;
                        }
                    }
                    count = 1;
                }
                else {
                    now = Character.toString(str.charAt(i));
                    // 현재 글자가 모음인 경우
                    if (must.contains(now)) {
                        check1 = true;
                        // 이전 글자가 모음인 경우
                        if (check2) {
                            // 같은 글자가 연속인지 확인
                            if (before.equals(now)) {
                                if (now.equals("e") || now.equals("o")) {
                                    if (count < 2) {
                                        count += 1;
                                        if (beforeCount == 1){
                                            beforeCount += 1;
                                        }
                                        else{
                                            acceptable = false;
                                            break;
                                        }
                                    }
                                    else {
                                        acceptable = false;
                                        break;
                                    }

                                }
                                else{
                                    acceptable = false;
                                    break;
                                }
                            }
                            // 모음이 연속인 경우
                            else {
                                if (count < 2){
                                    count += 1;
                                    if (now.equals("e") || now.equals("o")) {
                                        beforeCount = 1;
                                    }
                                    before = now;
                                }
                                else {
                                    acceptable = false;
                                    break;
                                }
                            }
                        }
                        // 이전 글자가 자음인 경우
                        else {
                            count = 1;
                            before = now;
                            if (now.equals("e") || now.equals("o")) {
                                beforeCount = 1;
                            }
                        }
                        check2 = true;
                    }
                    // 현재 글자가 자음인 경우
                    else {
                        beforeCount = 0;
                        if (before.equals(now)) {
                            acceptable = false;
                            break;
                        }
                        // 이전 글자가 모음인 경우
                        else if (check2) {
                            count = 1;
                            before = now;
                        }
                        // 이전 글자가 자음인 경우
                        if (!check2) {
                            if (count < 2) {
                                count += 1;
                                before = now;
                            }
                            else {
                                acceptable = false;
                                break;
                            }
                        }
                        check2 = false;
                    }
                }
            }
            if (check1 && acceptable) {
                System.out.println("<"+str+"> is acceptable.");
            }
            else {
                System.out.println("<"+str+"> is not acceptable.");
            }
        }
    }
}
