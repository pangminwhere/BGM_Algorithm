import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토 (BFS)
 */
public class Main {

    static class Tomato{
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] box;
    static StringTokenizer st;
    public static Queue<Tomato> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    que.offer(new Tomato(i, j, 0));
                }
            }
        }

        bfs();

    }

    public static void bfs() {
        int day = 0;

        while(!que.isEmpty()) {
            Tomato t = que.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (range_check(nx, ny)) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        que.add(new Tomato(nx, ny, day + 1));
                    }
                }
            }
        }

        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean range_check(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    public static boolean checkTomato() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
