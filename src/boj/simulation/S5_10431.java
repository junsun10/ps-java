// 줄세우기 ( 정답 )
// 알고리즘: 구현, 시뮬레이션

package boj.simulation;

import java.io.*;
import java.util.*;

public class S5_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수
        int p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 테스트 케이스 번호
            int index = Integer.parseInt(st.nextToken());
            // 물러난 횟수
            int count = 0;
            // 줄세울 배열
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 0; j < 20; j++) {
                // 추가할 학생 키
                int h = Integer.parseInt(st.nextToken());
                // 자기보다 큰 학생이 있는지 여부
                boolean check = false;

                for (int k = 0; k < arr.size(); k++) {
                    // 자기보다 큰 학생이 있으면 앞에 추가
                    if (arr.get(k) > h) {
                        arr.add(k, h);
                        // 자기 뒤 학생 수 더함
                        count += arr.size() - k - 1;
                        check = true;
                        break;
                    }
                }
                // 자기보다 큰 학생이 없었으면 맨 뒤에 추가
                if (!check) {
                    arr.add(h);
                }
            }
            System.out.println(index + " " + count);
        }
    }
}
