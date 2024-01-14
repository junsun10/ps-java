package swea.dx_24_winter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class N1_2 {

    static int start, end;
    static int sx, sy, ex, ey;
    static int arr[] = new int[150];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());

        init();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            if (start > end) {
               int temp = start;
               start = end;
               end = temp;
            }
            getIndex();
            if (sy >= ey) {
                bw.write("#" + (i+1) + " " + (Math.abs(sx-ex)+Math.abs(sy-ey)) + "\n");
            }
            else {
                bw.write("#" + (i+1) + " " + (Math.max(Math.abs(sx - ex), Math.abs(sy - ey))) + "\n");
            }
        }
        bw.flush();
        bw.close();
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
