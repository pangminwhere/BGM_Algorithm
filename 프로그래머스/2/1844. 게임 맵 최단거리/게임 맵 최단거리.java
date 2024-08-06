import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int r = curr[0], c = curr[1], dist = curr[2];
            
            if (r == n - 1 && c == m - 1) {
                return dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];
                
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                queue.add(new int[] {nr, nc, dist + 1});
                }        
            }
        }
    }
        return -1;
    }
}