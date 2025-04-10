// 촌수계산 (BFS)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] rel;
    static boolean[] visited;
    static int n, m;

    static class Pair {
        int node, distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 전체 사람 수

        // 촌수 계산할 두 사람 번호
        st = new StringTokenizer(br.readLine());
        int personA = Integer.parseInt(st.nextToken()); // 부모
        int personB = Integer.parseInt(st.nextToken()); // 자식

        visited = new boolean[n + 1];
        rel = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            rel[i] = new ArrayList<>();
        }

        m = Integer.parseInt(br.readLine());

        // 양방향으로 관계 저장
        for (int i= 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rel[a].add(b);
            rel[b].add(a);
        }

        int result = bfs(personA, personB);
        System.out.println(result);

        br.close();

    }

    static int bfs(int start, int target) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(start, 0));
        visited[start] = true;

        while (!que.isEmpty()) {
            Pair now = que.poll();
            int nowNode = now.node;
            int distance = now.distance;

            // 목표 노드를 찾으면 촌수 반환
            if (nowNode == target) {
                return distance;
            }

            for (int next : rel[nowNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(new Pair(next, distance + 1));
                }
            }
        }

        return -1;
    }
}
