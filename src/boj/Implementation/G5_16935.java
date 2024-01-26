// 배열 돌리기 3 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class G5_16935 {
    static int n, m, r;         // n * m 배열, 연산 r번
    static int[][] arr1, arr2;  // arr1: n * m 배열, arr2: m * n 배열
    static int[][] newArr1, newArr2;
    static boolean status = true;   // true: n * m 상태, false: m * n 상태

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr1 = new int[n][m];
        newArr1 = new int[n][m];
        arr2 = new int[m][n];
        newArr2 = new int[m][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 r회 진행
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken());
            move(num);
        }

        if (status) {
            printAnswer(arr1);
        }
        else {
            printAnswer(arr2);
        }
    }

    static void move(int x) {
        if (x == 1) {
            move1();
        }
        else if (x == 2) {
            move2();
        }
        else if (x == 3) {
            move3();
        }
        else if (x == 4) {
            move4();
        }
        else if (x == 5) {
            move5();
        }
        else {
            move6();
        }
    }

    // 상하 반전
    static void move1() {
        if (status) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newArr1[i][j] = arr1[n-i-1][j];
                }
            }
        }
        else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newArr2[i][j] = arr2[m-i-1][j];
                }
            }
        }
        copy();
    }

    // 좌우 반전
    static void move2() {
        if (status) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newArr1[i][j] = arr1[i][m-j-1];
                }
            }
        }
        else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newArr2[i][j] = arr2[i][n-j-1];
                }
            }
        }
        copy();
    }

    // 오른쪽 90도 회전
    static void move3() {
        if (status) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newArr2[j][n-i-1] = arr1[i][j];
                }
            }
            status = false;
        }
        else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newArr1[j][m-i-1] = arr2[i][j];
                }
            }
            status = true;
        }
        copy();
    }

    // 왼쪽 90도 회전
    static void move4() {
        if (status) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newArr2[m-j-1][i] = arr1[i][j];
                }
            }
            status = false;
        }
        else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newArr1[n-j-1][i] = arr2[i][j];
                }
            }
            status = true;
        }
        copy();
    }

    // 4등분 시계방향 돌리기
    static void move5() {
        if (status) {
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < m/2; j++) {
                    newArr1[i][j+m/2] = arr1[i][j];
                }
            }
            for (int i = 0; i < n/2; i++) {
                for (int j = m/2; j < m; j++) {
                    newArr1[i+n/2][j] = arr1[i][j];
                }
            }
            for (int i = n/2; i < n; i++) {
                for (int j = m/2; j < m; j++) {
                    newArr1[i][j-m/2] = arr1[i][j];
                }
            }
            for (int i = n/2; i < n; i++) {
                for (int j = 0; j < m/2; j++) {
                    newArr1[i-n/2][j] = arr1[i][j];
                }
            }
        }
        else {
            for (int i = 0; i < m/2; i++) {
                for (int j = 0; j < n/2; j++) {
                    newArr2[i][j+n/2] = arr2[i][j];
                }
            }
            for (int i = 0; i < m/2; i++) {
                for (int j = n/2; j < n; j++) {
                    newArr2[i+m/2][j] = arr2[i][j];
                }
            }
            for (int i = m/2; i < m; i++) {
                for (int j = n/2; j < n; j++) {
                    newArr2[i][j-n/2] = arr2[i][j];
                }
            }
            for (int i = m/2; i < m; i++) {
                for (int j = 0; j < n/2; j++) {
                    newArr2[i-m/2][j] = arr2[i][j];
                }
            }
        }
        copy();
    }

    // 4등분 반시계방향 돌리기
    static void move6() {
        if (status) {
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < m/2; j++) {
                    newArr1[i+n/2][j] = arr1[i][j];
                }
            }
            for (int i = 0; i < n/2; i++) {
                for (int j = m/2; j < m; j++) {
                    newArr1[i][j-m/2] = arr1[i][j];
                }
            }
            for (int i = n/2; i < n; i++) {
                for (int j = m/2; j < m; j++) {
                    newArr1[i-n/2][j] = arr1[i][j];
                }
            }
            for (int i = n/2; i < n; i++) {
                for (int j = 0; j < m/2; j++) {
                    newArr1[i][j+m/2] = arr1[i][j];
                }
            }
        }
        else {
            for (int i = 0; i < m/2; i++) {
                for (int j = 0; j < n/2; j++) {
                    newArr2[i+m/2][j] = arr2[i][j];
                }
            }
            for (int i = 0; i < m/2; i++) {
                for (int j = n/2; j < n; j++) {
                    newArr2[i][j-n/2] = arr2[i][j];
                }
            }
            for (int i = m/2; i < m; i++) {
                for (int j = n/2; j < n; j++) {
                    newArr2[i-m/2][j] = arr2[i][j];
                }
            }
            for (int i = m/2; i < m; i++) {
                for (int j = 0; j < n/2; j++) {
                    newArr2[i][j+n/2] = arr2[i][j];
                }
            }
        }
        copy();
    }

    // 배열 복사
    static void copy() {
        if (status) {
            for (int i = 0; i < n; i++) {
                arr1[i] = newArr1[i].clone();
            }
        }
        else {
            for (int i = 0; i < m; i++) {
                arr2[i] = newArr2[i].clone();
            }
        }
    }

    // 정답 출력
    static void printAnswer(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }
}
