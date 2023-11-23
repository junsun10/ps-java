// 최소비용 구하기 ( 정답 확인 )
// 알고리즘: 다익스트라

package boj.dijkstra;

import java.io.*;
import java.util.*;

public class G5_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, start, end;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    static class Edge {
        int index, price;

        Edge(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    static void read() throws Exception {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges.get(from).add(new Edge(to, price));
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void solution() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0,start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int d = temp[0];
            int now = temp[1];

            if (dist[end] < d) {
                continue;
            }
            for (Edge edge : edges.get(now)) {
                if (dist[now] + edge.price < dist[edge.index]) {
                    dist[edge.index] = dist[now] + edge.price;
                    pq.add(new int[]{dist[edge.index],edge.index});
                }
            }
        }
        System.out.println(dist[end]);
    }
}
