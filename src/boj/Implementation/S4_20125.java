// 쿠키의 신체 측정 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;

public class S4_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        int[] heart = new int[2];
        String temp;

        boolean checkHead = false;


        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                char now = temp.charAt(j);
                arr[i][j] = now;
                if (!checkHead && now == '*') {
                    checkHead = true;
                    heart[0] = i+1;
                    heart[1] = j;
                }
            }
        }

        int leftArm = 0;
        int rightArm = 0;
        int body = 0;
        int[] bodyIndex = new int[2];
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = heart[1]-1; i >= 0 ; i--) {
            if (arr[heart[0]][i] == '*') {
                leftArm += 1;
            }
            else {
                break;
            }
        }
        for (int i = heart[1]+1; i < n ; i++) {
            if (arr[heart[0]][i] == '*') {
                rightArm += 1;
            }
            else {
                break;
            }
        }
        for (int i = heart[0]+1; i < n ; i++) {
            if (arr[i][heart[1]] == '*') {
                body += 1;
            }
            else {
                bodyIndex[0] = i-1;
                bodyIndex[1] = heart[1];
                break;
            }
        }
        for (int i = bodyIndex[0]+1; i < n ; i++) {
            if (arr[i][bodyIndex[1]-1] == '*') {
                leftLeg += 1;
            }
            else {
                break;
            }
        }
        for (int i = bodyIndex[0]+1; i < n ; i++) {
            if (arr[i][bodyIndex[1]+1] == '*') {
                rightLeg += 1;
            }
            else {
                break;
            }
        }

        System.out.printf("%d %d\n", heart[0]+1, heart[1]+1);
        System.out.printf("%d %d %d %d %d\n", leftArm, rightArm, body, leftLeg, rightLeg);
    }
}
