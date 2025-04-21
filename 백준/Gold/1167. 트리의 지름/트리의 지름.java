/*
트리의 지름 (BFS)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Node>[] que;
    static int max = 0;
    static boolean[] visited;
    static int node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        que = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            que[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                que[s].add(new Node(e, cost));
            }
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(node, 0);

        System.out.println(max);

    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for (int i = 0; i < que[x].size(); i++) {
            Node n = que[x].get(i);
            if (!visited[n.edge]) {
                dfs(n.edge, n.distance + len);
                visited[n.edge] = true;
            }
        }
    }

    public static class Node {
        int edge;
        int distance;

        public Node (int edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }
    }
}
