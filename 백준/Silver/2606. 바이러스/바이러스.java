import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int count, num, network;
    static boolean[] visited;
    static List[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        network = Integer.parseInt(br.readLine());
        visited = new boolean[num + 1];
        computers = new List[num + 1];
        count = 0;

        for (int i = 1; i < num + 1; i++) {
            computers[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < network; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }

        bfs(1);

        System.out.println(count - 1);
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()) {
            int now = que.poll();
            if (!visited[now]) {
                count++;
                visited[now] = true;
                for (int i = 0; i < computers[now].size(); i++) {
                    que.add((int)computers[now].get(i));
                }
            }
        }
    }
}
