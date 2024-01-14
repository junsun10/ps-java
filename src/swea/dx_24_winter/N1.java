package swea.dx_24_winter;

import java.util.Scanner;

class N1 {

    static int start, end;
    static int sx, sy, ex, ey;
    static int arr[] = new int[150];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        init();

        for (int i = 0; i < T; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            if (start > end) {
               int temp = start;
               start = end;
               end = temp;
            }
            getIndex();
            if (sy >= ey) {
                System.out.printf("#%d %d\n", i+1, Math.abs(sx-ex)+Math.abs(sy-ey));
            }
            else {
                System.out.printf("#%d %d\n", i + 1, Math.max(Math.abs(sx - ex), Math.abs(sy - ey)));
            }
        }
    }

    static void init() {
        for (int i = 1; i < 150; i++) {
            arr[i] = arr[i-1] + i;
        }
    }

    static void getIndex() {
        for (int i = 1; i < 150; i++) {
            if (start > arr[i-1] & start <= arr[i]) {
                sx = i;
            }
            if (end > arr[i-1] & end <= arr[i]) {
                ex = i;
            }
        }
        for (int i = 1; i <= arr[sx] - arr[sx-1]; i++) {
            if (arr[sx-1] + i == start) {
                sy = i;
            }
        }
        for (int i = 1; i <= arr[ex] - arr[ex-1]; i++) {
            if (arr[ex-1] + i == end) {
                ey = i;
            }
        }
    }
}
