// 감시 피하기 ( 정답 )
// 알고리즘: 백트래킹, 브루트포스

package boj.backtracking;

import java.io.*;
import java.util.*;

public class G5_18428 {

    static int n;
    static String[][] arr;  // 복도
    static ArrayList<int[]> students = new ArrayList<>();   // 학생 좌쵸
    static int[][] walls = new int[3][2];   // 선택된 장애물 위치
    static boolean answer = false;  // 정답 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken();
                if (arr[i][j].equals("S")) {    // 학생 좌표 저장
                    students.add(new int[] {i, j});
                }
            }
        }

        solution();
    }

    static void solution() {

        pick(0,0, 0);   // 장애물 3개 선택

        if (answer) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    static void pick(int x, int y, int c) {
        if (answer) {
            return;
        }

        if (x == n & c != 3) {
            return;
        }

        // 장애물 3개 선택 시 계산
        if (c == 3) {
            cal();
        }

        else {
            // x와 같은 행
            for (int i = y; i < n; i++) {
                if (arr[x][i].equals("X")) {
                    walls[c][0] = x;
                    walls[c][1] = i;
                    if (i == n-1) {
                        pick(x + 1, 0, c + 1);
                    }
                    else {
                        pick(x, i + 1, c + 1);
                    }
                }
            }
            // x 다음 행
            for (int i = x + 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j].equals("X")) {
                        walls[c][0] = i;
                        walls[c][1] = j;
                        if (j == n-1) {
                            pick(x + 1, 0, c + 1);
                        }
                        else {
                            pick(i, j + 1, c + 1);
                        }
                    }
                }
            }
        }


    }

    static void cal() {
        boolean ok = true;

        for (int[] wall : walls) {
            arr[wall[0]][wall[1]] = "O";
        }

        for (int[] student : students) {
            if (!ok) {
                break;
            }

            int x = student[0];
            int y = student[1];

            // 상
            for (int i = x-1; i >= 0 ; i--) {
                if (arr[i][y].equals("O")) {
                    break;
                }
                else if (arr[i][y].equals("T")) {
                    ok = false;
                    break;
                }
            }
            // 하
            for (int i = x+1; i < n; i++) {
                if (arr[i][y].equals("O")) {
                    break;
                }
                else if (arr[i][y].equals("T")) {
                    ok = false;
                    break;
                }
            }
            // 좌
            for (int i = y-1; i >= 0; i--) {
                if (arr[x][i].equals("O")) {
                    break;
                }
                else if (arr[x][i].equals("T")) {
                    ok = false;
                    break;
                }
            }
            // 우
            for (int i = y+1; i < n; i++) {
                if (arr[x][i].equals("O")) {
                    break;
                }
                else if (arr[x][i].equals("T")) {
                    ok = false;
                    break;
                }
            }
        }

        for (int[] wall : walls) {
            arr[wall[0]][wall[1]] = "X";
        }

        if (ok) {
            answer = true;
        }
    }
}
