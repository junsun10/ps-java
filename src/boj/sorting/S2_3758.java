// KCPC ( 정답 )
// 알고리즘: 정렬
// 팀별 점수를 계산한 뒤 조건에 따라 순위 정렬

package boj.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_3758 {
    public static int T;    // 테스트 케이스 수
    public static int n,k,t,m;    // n: 팀 개수, k: 문제 개수, t: 내 팀 ID, m: 로그 엔트리의 개수
    public static int[][] logs;   // 입력 로그
    public static ArrayList<Team> scores = new ArrayList<>();    // 팀 객체 리스트

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static class Team implements Comparable<Team> {
        int id;
        int score;
        int count;

        Team(int id, int score, int count) {
            this.id = id;
            this.score = score;
            this.count = count;
        }

        // 총점이 높은 순
        // 총점이 같으면 제출 횟수가 적은 순
        // 총점과 제출 횟수가 같으면 마지막 제출 시간이 더 빠른순으로 정렬
        @Override
        public int compareTo(Team t) {
            if (this.score == t.score) {
                if (this.count == t.count) {
                    for (int i = m-1; i >= 0; i--) {
                        if (logs[i][0] == this.id) {
                            return 1;
                        }
                        else if (logs[i][0] == t.id) {
                            return -1;
                        }
                    }
                }
                return this.count - t.count;
            }
            return t.score - this.score;
        }
    }

    public static void main(String[] args) throws Exception {
        read(0);    // 테스트 케이스 수 입력
        for (int i = 0; i < T; i++) {
            read(1);    // 문제 입력
            solution();      // 풀이 진행
        }
        bw.flush();          // 정답 출력
    }

    // 입력 함수
    public static void read(int type) throws Exception {
        // 테스트 케이스 입력
        if (type == 0) {
            T = Integer.parseInt(br.readLine());
        }
        // 문제 입력
        else {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());   // n: 팀 개수
            k = Integer.parseInt(st.nextToken());   // k: 문제 개수
            t = Integer.parseInt(st.nextToken());   // t: 내 팀 ID
            m = Integer.parseInt(st.nextToken());   // m: 로그 엔트리의 개수

            logs = new int[m][3];   // 로그 저장 배열 초기화

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int id = Integer.parseInt(st.nextToken());      // 팁 번호
                int num = Integer.parseInt(st.nextToken());     // 문제 번호
                int score = Integer.parseInt(st.nextToken());   // 점수

                // 로그에 저장
                logs[i][0] = id;
                logs[i][1] = num;
                logs[i][2] = score;
            }
        }
    }

    // 풀이 함수
    public static void solution() throws Exception {
        scores.clear(); // 점수 리스트 초기화
        int[][] saveScore = new int[n+1][k+1];  // [팀 번호][문제 번호] 인덱스에 최고 점수 저장
        int[] countSubmit = new int[n+1];   // [팀 번호] 인덱스에 총 문제 제출 수 저장

        // 전체 로그
        for (int i = 0; i < m; i++) {
            int nowId = logs[i][0];     // 현재 로그 팀 번호
            int nowNum = logs[i][1];    // 현재 로그 문제 번호
            int nowScore = logs[i][2];  // 현재 로그 점수

            countSubmit[nowId] += 1;    // 현재 로그 팀에 제출 횟수 추가
            if (nowScore > saveScore[nowId][nowNum]) {  // 최고 점수 비교
                saveScore[nowId][nowNum] = nowScore;
            }
        }

        // 1팀 부터 n팀 까지 총점 계산
        for (int i = 1; i < n+1; i++) {
            int sum = 0;
            for (int j = 1; j < k+1; j++) {
                sum += saveScore[i][j];
            }
            scores.add(new Team(i,sum,countSubmit[i])); // 팀 객체 생성 뒤 리스트에 저장 (팀 번호, 총점, 문제 제출 횟수)
        }

        Collections.sort(scores);   // 조건에 맞게 정렬

        // 문제에서 주어진 팀 등수 찾기
        for (int i = 0; i < n; i++) {
            if (scores.get(i).id == t) {
                String str = (i+1)+"\n";
                bw.write(str);
                break;
            }
        }
    }
}
