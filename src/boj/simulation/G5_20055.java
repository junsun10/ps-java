// 컨베이어 벨트 위의 로봇 ( 정답 )
// 알고리즘: 구현, 시뮬레이션
// 배열 돌리기, 조건에 맞춰 구현

package boj.simulation;

import java.io.*;
import java.util.*;

public class G5_20055 {
    static int n, k;    // n: 벨트의 길이 2*n, k: 내구도 0 종료 조건 개수
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();   // 벨트 상태 저장하는 배열

    public static void main(String[] args) throws Exception {
        int answer = 0; // 진행 단계 기록

        read(); // 문제 입력

        // 단계 진행
        while (true) {
            if (round()) {  // 단계가 성공적으로 통과하면 1 증가
                answer += 1;
            }
            else {  // 실패시 현재 진행 단계 출력을 위해 1 더한 뒤 출력
                System.out.println(answer+1);
                break;
            }

        }
    }

    static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 벨트 내구도 할당
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2*n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(st.nextToken())); // 내구도
            temp.add(0);    // 로봇 없으면 0, 있으면 1
            arr.add(temp);
        }
    }

    static boolean round() {
        // 1. 회전
        ArrayList<Integer> last = arr.get(2*n-1);
        for (int i = 2*n-1; i > 0; i--) {
            arr.set(i,arr.get(i-1));
        }
        arr.set(0,last);

        // 내리는 지점 로봇 내리기
        if (arr.get(n-1).get(1) == 1) {
            arr.get(n-1).set(1,0);
        }

        // 2. 이동 진행
        for (int i = n-2; i >= 0; i--) {
            // 현재 위치에 로봇이 있고 다음칸에 로봇이 없고 내구도가 1 이상이면
            if (arr.get(i).get(1) == 1 && arr.get(i+1).get(1) == 0 && arr.get(i+1).get(0) > 0) {
                arr.get(i+1).set(0,arr.get(i+1).get(0)-1);  // 내구도 감소
                arr.get(i+1).set(1,1);  // 로봇 이동
                arr.get(i).set(1,0);    // 로봇 이동
            }
        }

        // 내리는 지점 로봇 내리기
        if (arr.get(n-1).get(1) == 1) {
            arr.get(n-1).set(1,0);
        }

        // 3. 로봇 올리기
        if (arr.get(0).get(0) > 0) {
            arr.get(0).set(1,1);
            arr.get(0).set(0,arr.get(0).get(0)-1);
        }

        // 4. 종료 조건 확인
        int count = 0;
        for (int i = 0; i < 2*n; i++) {
            if (arr.get(i).get(0) == 0) {
                count += 1;
            }
        }
        // 내구도 0인 위치가 k개 이상이면 종료
        if (count >= k) {
            return false;
        }
        else {
            return true;
        }
    }
}
