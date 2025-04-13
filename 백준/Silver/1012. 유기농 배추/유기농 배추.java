import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 유기농 배추(BFS)
 **/

public class Main {

    static int[][] ground;
    static boolean[][] visited;
    static int M, N, K;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1,-1, 0, 0};

    static class Cabbage {
        int x;
        int y;

        public Cabbage (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 개수
        int testCase = Integer.parseInt(br.readLine());


        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            ground = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                ground[x][y] = 1;
            }

            int count = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (ground[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
         Queue<Cabbage> que = new LinkedList<>();
         que.offer(new Cabbage(x, y));
         visited[x][y] = true;


         while (!que.isEmpty()) {
             Cabbage now = que.poll();

             for (int i = 0; i < 4; i++) {
                 int nextX = dx[i] + now.x;
                 int nextY = dy[i] + now.y;

                 if (range_check(nextX, nextY)) {
                     if (ground[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                         visited[nextX][nextY] = true;
                         que.offer(new Cabbage(nextX, nextY));
                     }
                 }
             }
         }
    }

    static boolean range_check(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    }
}
