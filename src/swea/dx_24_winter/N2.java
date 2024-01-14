package swea.dx_24_winter;

import java.util.*;

class N2 {
    static int t;
    static int n;
    static int answer;
    static ArrayList<int[]> arr = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            answer = Integer.MAX_VALUE;
            arr.clear();
            n = sc.nextInt();
            dp = new int[n];
            int temp = 0;
            for (int j = 0; j < n; j++) {
                int[] input = new int[4];
                for (int k = 0; k < 3; k++) {
                    input[k] = sc.nextInt();
                }
                input[3] = input[0] + input[1] + input[2];
                arr.add(input);
                dp[j] = temp + input[3] - Math.max(input[0], Math.max(input[1], input[2]));
                temp = dp[j];
            }
            solution(i);
        }
    }

    static void solution(int index) {
        int count = 0;
        boolean[] visited = new boolean[3];
        int sum = 0;
        re(count, visited, sum);
        if (answer == Integer.MAX_VALUE) {
            System.out.printf("#%d -1\n", index+1);
        }
        else {
            System.out.printf("#%d %d\n", index+1, answer);
        }
    }

    static void re(int count, boolean[] visited, int sum) {
        if (count == n) {
            if (visited[0] & visited[1] & visited[2]) {
                answer = Math.min(sum, answer);
            }
            return;
        }
        if (count > 0) {
            if (sum + dp[n-1] - dp[count-1] >= answer) {
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            int temp = arr.get(count)[3] - arr.get(count)[i];
            sum += temp;
            if (visited[i]) {
                re(count+1, visited, sum);
            }
            else {
                visited[i] = true;
                re(count+1, visited, sum);
                visited[i] = false;
            }
            sum -= temp;
        }
    }

}
