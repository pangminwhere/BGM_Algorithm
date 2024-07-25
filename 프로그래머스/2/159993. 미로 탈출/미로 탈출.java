import java.util.*;

class Solution {
    
    static final int[] D_X = {-1, 0, 1, 0}; // x 이동 좌표
    static final int[] D_Y = {0, -1, 0, 1}; // y 이동 좌표
    
    int eX; // 도착지 x좌표
    int eY; // 도착지 y좌표
    
    public int solution(String[] maps) {        
        int sX = 0, sY = 0, lX = 0, lY = 0; // s는 출발지 좌표, l은 레버 좌표
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    sX = i;
                    sY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    eX = i;
                    eY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lX = i;
                    lY = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()]; // 방문여부
        
        int step = bfs(new Node(sX, sY, 0), lX, lY, maps, visited, false);  // bfs로 먼저 시작점 -> 레버의 최단 거리 
        if (step == -1) return -1; // 만약 갈 수 없는 경우
        
        int sToE = bfs(new Node(sX, sY, step * 2), eX, eY, maps, visited, true);  // 시작점 -> 레버 -> 시작점 -> 도착점   
        int lToE = bfs(new Node(lX, lY, step), eX, eY, maps, visited, true);   // 시작점 -> 레버 -> 도착점
        
        if (lToE == -1) return sToE;
        else if (sToE == -1) return lToE;
        return Math.min(lToE, sToE);
    }
    
    private int bfs(Node node, int eX, int eY, String[] maps, boolean[][] visited, boolean refresh) {
        Queue<Node> queue = new ArrayDeque<>(); // bfs를 위한 queue
        queue.add(node); 
        
        if (refresh) {
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[i].length; j++)
                    visited[i][j] = false; // 방문 여부 초기화
            }
        }

        while(!queue.isEmpty()) {
            
            Node n = queue.poll(); // 큐에서 꺼내기
            
            if (n.x == eX && n.y == eY) return n.step; // 최단 거리 리턴
            if (visited[n.x][n.y]) continue; // 방문한 경우 패스
            
            visited[n.x][n.y] = true; // 방문 여부 설정
            
            for (int k = 0; k < 4; k++) {
                int newX = n.x + D_X[k]; // 새로운 좌표 설정
                int newY = n.y + D_Y[k];
                
                if (validRange(newX, newY, maps, visited)) {
                    queue.add(new Node(newX, newY, n.step + 1));
                }
            }
        }
        return -1;
    }
    
    // 방문한 경우가 아니고 유효한 인덱스 && 지나갈 수 있는 경로일 경우
    private boolean validRange(int x, int y, String[] maps, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < maps.length && y < maps[x].length()
            && !visited[x][y] && (maps[x].charAt(y) != 'X');
    }
    
    class Node {
        int x;
        int y;
        int step;
        
        Node (int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}