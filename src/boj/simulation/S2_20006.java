// 랭킹전 대기열 ( 정답 )
// 알고리즘: 구현, 시뮬레이션

package boj.simulation;

import java.io.*;
import java.util.*;

public class S2_20006 {
    public static int p, m;     // p: 플레이어 수, m: 방 정원

    // 방 클래스
    public static class Room {
        int level;  // 방장 레벨
        int count;  // 방 인원수
        ArrayList<Player> players = new ArrayList<>();  // 참가자 목록

        Room (int level, Player player) {
            this.level = level;
            this.players.add(player);
            this.count = 1;
        }
    }

    // 플레이어 클래스
    public static class Player implements Comparable<Player> {
        int level;      // 플레이어 레벨
        String name;    // 플레이어 이름

        Player (int level, String name) {
            this.level = level;
            this.name = name;
        }

        // 이름 사전순으로 정렬
        @Override
        public int compareTo(Player p) {
            return (this.name).compareTo(p.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        p = Integer.parseInt(st.nextToken());   // 플레이어 수
        m = Integer.parseInt(st.nextToken());   // 방 정원
        Deque<Room> dq = new ArrayDeque<>();    // 방 목록

        // 플레이어 입력
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean check = false;  // 맞는 방 찾았는지 여부
            // 모든 방 앞에서부터 탐색
            for (Room room: dq) {
                // 레벨 조건이 맞고 방이 다 차지 않은 경우 입장
                if (Math.abs(level-room.level)<=10 & room.count < m) {
                    room.players.add(new Player(level, name));  // 플레이어 생성 뒤 방에 저장
                    room.count += 1;    // 방 인원 증가
                    check = true;       // 방을 찾음
                    break;
                }
            }
            // 방을 찾지 못한 경우 새로운 방 생성
            if (!check) {
                dq.addLast(new Room(level, new Player(level, name)));   // 플레이어 생성, 방 생성, 목록에 저장

            }
        }

        // 모든 방 앞에서부터 출력
        for (Room room : dq) {
            // 정원이 다 찬 경우
            if (room.count == m) {
                System.out.println("Started!");
            }
            // 다 차지 못한 경우
            else {
                System.out.println("Waiting!");
            }
            // 참가자 이름 사전순으로 정렬
            Collections.sort(room.players);
            // 순서대로 출력
            for (int i = 0; i < room.players.size(); i++) {
                System.out.printf("%d %s\n", room.players.get(i).level, room.players.get(i).name);
            }
        }
    }
}
