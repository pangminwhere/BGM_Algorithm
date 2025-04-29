/*
효율적인 해킹 (그래프 BFS)
 */

import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    static int[] answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        network = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            network[S].add(E);
        }

        for (int i = 1; i <= N ; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, answer[i]);
        }

        for (int i = 1; i <= N ; i++) {
            if (answer[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : network[now]) {
                if (visited[i] == false) {
                    visited[i] = true;
                    answer[i]++;
                    q.add(i);
                }
            }
        }
    }
}
