import java.util.*;

class Solution {
    class Pair {
        int x, y, count;
        
        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = check(places[i]);
        }
        return answer;
    }
    
    int check(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!bfs(i, j, place)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    boolean bfs(int i, int j, String[] place) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[5][5];
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(i, j, 0));
        visited[i][j] = true;
        
        while (!que.isEmpty()) {
            Pair pair = que.remove();
            if (pair.count >= 2) continue;
            
            for (int x = 0; x < 4; x++) {
                int nX = pair.x + dx[x];
                int nY = pair.y + dy[x];
                
                if (inRange(nX, nY) && place[nX].charAt(nY) != 'X') {
                    if (!visited[nX][nY]) {
                        if (place[nX].charAt(nY) == 'P') {
                            return false;
                        }
                        que.add(new Pair(nX, nY, pair.count + 1));
                        visited[nX][nY] = true;
                    }
                }
            }
        }
        return true;
    }
    
    boolean inRange(int r, int c) {
        return (r >= 0) && (r < 5) && (c >= 0) && (c < 5);
    }
}