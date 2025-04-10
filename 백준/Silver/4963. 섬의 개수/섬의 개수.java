import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int arr[][];
    static boolean visited[][];
    static int dirX[] = {0, 0, -1, 1, -1, 1, -1, 1}; // 상 하 좌 우 대각 상좌, 상우, 하좌, 하우
    static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1}; // 상 하 좌 우 대각 상좌, 상우, 하좌, 하우

    static int w, h, nowX, nowY;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        String str = " ";

        while( !(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island_count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    if (!visited[i][j] && arr[i][j] == 1) {
                        BFS(i, j);
                        island_count++;
                    }
                }
            }

            sb.append(island_count).append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<Node>();
        visited[x][y] = true;

        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 8; i++) {
                nowX = dirX[i] + node.x;
                nowY = dirY[i] + node.y;

                if (range_check() && !visited[nowX][nowY] && arr[nowX][nowY] == 1) {
                    visited[nowX][nowY] = true;
                    q.offer(new Node(nowX, nowY));
                }
            }
        }
    }

    static boolean range_check() {
        return (nowX >= 0 && nowY >= 00 && nowX < h && nowY < w);
    }
}
