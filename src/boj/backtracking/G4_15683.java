// 감시 ( 정답 )
// 알고리즘: 백트래킹

package boj.backtracking;

import java.io.*;
import java.util.*;

public class G4_15683 {
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> cctv = new ArrayList<>();
    static ArrayList<int[]> cctv5 = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = n*m;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if (v == 5) {
                    cctv5.add(new int[]{i,j});
                }
                else if (v != 0 & v != 6) {
                    cctv.add(new int[] {i,j, map[i][j]});
                }
            }
        }

        solution();
    }

    static void solution() {
        handle5();
        dfs(map, 0);
        System.out.println(answer);
    }

    static void handle5() {
        for (int i = 0; i < cctv5.size(); i++) {
            int[] top = cctv5.get(i);
            int x = top[0];
            int y = top[1];
            // 상
            int add = -1;
            while (x+add >= 0) {
                if (map[x+add][y] == 6) {
                    break;
                }
                else if (map[x+add][y] == 0) {
                    map[x+add][y] = -1;
                }
                add -= 1;
            }
            // 하
            add = 1;
            while (x+add < n) {
                if (map[x+add][y] == 6) {
                    break;
                }
                else if (map[x+add][y] == 0) {
                    map[x+add][y] = -1;
                }
                add += 1;
            }
            // 좌
            add = -1;
            while (y+add >= 0) {
                if (map[x][y+add] == 6) {
                    break;
                }
                else if (map[x][y+add] == 0) {
                    map[x][y+add] = -1;
                }
                add -= 1;
            }
            // 우
            add = 1;
            while (y+add < m) {
                if (map[x][y+add] == 6) {
                    break;
                }
                else if (map[x][y+add] == 0) {
                    map[x][y+add] = -1;
                }
                add += 1;
            }
        }
    }

    static void dfs(int[][] arr, int index) {
        if (index == cctv.size()) {
            answer = Math.min(answer, countEmpty(arr));
            return;
        }
        int[][] nowMap;
        for (int i = index; i < cctv.size(); i++) {
            int cctvNum = cctv.get(i)[2];

            switch(cctvNum) {
                case 1:
                    nowMap = copyMap(arr);
                    handleUp(nowMap, i);
                    dfs(nowMap, i + 1);

                    nowMap = copyMap(arr);
                    handleDown(nowMap, i);
                    dfs(nowMap, i + 1);

                    nowMap = copyMap(arr);
                    handleLeft(nowMap, i);
                    dfs(nowMap, i + 1);

                    nowMap = copyMap(arr);
                    handleRight(nowMap, i);
                    dfs(nowMap, i + 1);
                    break;

                case 2:
                    // 상, 하
                    nowMap = copyMap(arr);
                    handleUp(nowMap, i);
                    handleDown(nowMap, i);
                    dfs(nowMap, i + 1);

                    // 좌, 우
                    nowMap = copyMap(arr);
                    handleLeft(nowMap, i);
                    handleRight(nowMap, i);
                    dfs(nowMap, i + 1);
                    break;

                case 3:
                    // 상, 우
                    nowMap = copyMap(arr);
                    handleUp(nowMap, i);
                    handleRight(nowMap, i);
                    dfs(nowMap, i + 1);

                    // 우, 하
                    nowMap = copyMap(arr);
                    handleRight(nowMap, i);
                    handleDown(nowMap, i);
                    dfs(nowMap, i + 1);

                    // 하, 좌
                    nowMap = copyMap(arr);
                    handleDown(nowMap, i);
                    handleLeft(nowMap, i);
                    dfs(nowMap, i + 1);

                    // 좌, 상
                    nowMap = copyMap(arr);
                    handleLeft(nowMap, i);
                    handleUp(nowMap, i);
                    dfs(nowMap, i + 1);
                    break;

                case 4:
                    // 상, 우, 하
                    nowMap = copyMap(arr);
                    handleUp(nowMap, i);
                    handleRight(nowMap, i);
                    handleDown(nowMap, i);
                    dfs(nowMap, i + 1);

                    // 우, 하, 좌
                    nowMap = copyMap(arr);
                    handleRight(nowMap, i);
                    handleDown(nowMap, i);
                    handleLeft(nowMap, i);
                    dfs(nowMap, i + 1);

                    // 하, 좌, 상
                    nowMap = copyMap(arr);
                    handleDown(nowMap, i);
                    handleLeft(nowMap, i);
                    handleUp(nowMap, i);
                    dfs(nowMap, i + 1);

                    // 좌, 상, 우
                    nowMap = copyMap(arr);
                    handleLeft(nowMap, i);
                    handleUp(nowMap, i);
                    handleRight(nowMap, i);
                    dfs(nowMap, i + 1);
                    break;
            }
        }
    }

    static int[][] copyMap(int[][] arr) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    static void handleUp(int[][] arr, int index) {
        int x = cctv.get(index)[0];
        int y = cctv.get(index)[1];
        int add = -1;
        while (x + add >= 0) {
            if (arr[x + add][y] == 6) {
                break;
            }
            else if (arr[x + add][y] == 0) {
                arr[x + add][y] = -1;
            }
            add -= 1;
        }
    }
    static void handleDown(int[][] arr, int index) {
        int x = cctv.get(index)[0];
        int y = cctv.get(index)[1];
        int add = 1;
        while (x + add < n) {
            if (arr[x + add][y] == 6) {
                break;
            }
            else if (arr[x + add][y] == 0) {
                arr[x + add][y] = -1;
            }
            add += 1;
        }
    }
    static void handleLeft(int[][] arr, int index) {
        int x = cctv.get(index)[0];
        int y = cctv.get(index)[1];
        int add = -1;
        while (y + add >= 0) {
            if (arr[x][y + add] == 6) {
                break;
            }
            else if (arr[x][y + add] == 0) {
                arr[x][y + add] = -1;
            }
            add -= 1;
        }
    }
    static void handleRight(int[][] arr, int index) {
        int x = cctv.get(index)[0];
        int y = cctv.get(index)[1];
        int add = 1;
        while (y + add < m) {
            if (arr[x][y + add] == 6) {
                break;
            }
            else if (arr[x][y + add] == 0) {
                arr[x][y + add] = -1;
            }
            add += 1;
        }
    }

    static int countEmpty(int[][] arr) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
