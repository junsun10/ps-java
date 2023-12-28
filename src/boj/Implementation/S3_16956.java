// 늑대와 양 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S3_16956 {
    static int r, c;    //  목장 크기
    static int[][] arr; // 목장

    static ArrayList<int[]> w = new ArrayList<>();  // 늑대 좌표
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean available = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j) == '.') {
                    arr[i][j] = 0;
                }
                else if (input.charAt(j) == 'S') {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = 2;
                    w.add(new int[]{i, j});
                }
            }
        }

        solution();
    }

    static void solution() {
        addWall();
        if (!available) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
            printArr();
        }
    }

    // 늑대 주변을 벽으로 감싸는 함수
    static void addWall() {
        for (int[] ints : w) {
            if (available) {
                for (int i = 0; i < 4; i++) {
                    int x = ints[0] + dx[i];
                    int y = ints[1] + dy[i];
                    if (x >= 0 & x < r & y >= 0 & y < c) {
                        if (arr[x][y] == 0) {
                            arr[x][y] = 3;
                        }
                        else if (arr[x][y] == 1) {  // 늑대와 양이 붙어있으면 불가능
                            available = false;
                            break;
                        }
                    }
                }
            }
            else {
                break;
            }
        }
    }

    static void printArr() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) {
                    System.out.printf(".");
                }
                else if (arr[i][j] == 1) {
                    System.out.printf("S");
                }
                else if (arr[i][j] == 2) {
                    System.out.printf("W");
                }
                else {
                    System.out.print("D");
                }
            }
            System.out.println();
        }
    }
}
