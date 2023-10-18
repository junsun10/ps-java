// 크로스 컨트리 ( 정답 )
// 알고리즘: 구현

package boj.Implementation;

import java.io.*;
import java.util.*;

public class S3_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 테스트 케이스 수
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());    // 전체 참가자 수
            st = new StringTokenizer(br.readLine(), " ");   // 팀 번호 입력

            int[] score = new int[n];  // 등수 배열
            int[] team = new int[201];  // 팀당 참가자 수 저장
            ArrayList<Integer> availableTeam = new ArrayList<>(); // 6명이 출전한 팀 번호 저장

            // 등수 저장
            for (int i = 0; i < n; i++) {
                int teamNum = Integer.parseInt(st.nextToken()); // 팀 번호
                score[i] = teamNum; // 등수 배열에 저장
                team[teamNum] += 1; // 참가자 수 증가
                if (team[teamNum] == 6) {   // 6명이 참가한 팀 저장
                    availableTeam.add(teamNum);
                }
            }

            int scoreCount = 1; // 점수 변수
            int[][] teamScore = new int[201][3];    // 1차원: 전체 팀, 2차원: 점수합, 4명 카운트, 5등 점수
            // 점수 계산
            for (int i = 0; i < n; i++) {
                // 정상 팀인 경우
                if (availableTeam.contains(score[i])) {
                    // 4등까지만 더함
                    if (teamScore[score[i]][1] < 4) {
                        teamScore[score[i]][0] += scoreCount;
                        teamScore[score[i]][1] += 1;
                    }
                    // 5등 점수 저장
                    else if (teamScore[score[i]][1] == 4) {
                        teamScore[score[i]][2] = scoreCount;
                        teamScore[score[i]][1] += 1;
                    }
                    scoreCount += 1;
                }
            }

            int[] answer = new int[2];  // 1등 팀, 1등 점수
            answer[1] = (n+1)*(n+1);
            for (int i = 0; i < availableTeam.size(); i++) {
                int nowScore = teamScore[availableTeam.get(i)][0];  // 현재 점수
                // 현재 점수가 최소 점수보다 더 낮은 경우
                if (nowScore < answer[1]) {
                    answer[1] = nowScore;   // 최소 점수 갱신
                    answer[0] = availableTeam.get(i);   // 1등 팀 갱신
                }
                // 동점인 경우 5등 값 비교
                else if (nowScore == answer[1]) {
                    // 현재 팀 5등이 기존 팀 5등보다 점수가 낮으면 갱신
                    if (teamScore[availableTeam.get(i)][2] < teamScore[answer[0]][2]) {
                        answer[0] = availableTeam.get(i);
                    }
                }
            }
            System.out.println(answer[0]);  // 정답 출력
        }
    }
}