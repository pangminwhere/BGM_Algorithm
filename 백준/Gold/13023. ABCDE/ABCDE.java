/*
ABCDE/친구 관계 파악하기 (DFS)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] friends;
    static int N, M;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N];
        visited = new boolean[N];
        flag = false;
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (flag) {
                break;
            }
        }

        if (flag) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static void DFS(int V, int depth) {

        if (depth == 5 || flag) {
            flag = true;
            return;
        }

        visited[V] = true;

        for (int i : friends[V]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[V] = false;
    }
}
