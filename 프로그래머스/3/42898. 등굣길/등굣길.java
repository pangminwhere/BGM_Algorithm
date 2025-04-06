class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] graph = new int[n+1][m+1];
        
        for (int i = 0; i < puddles.length; i++) {
            graph[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        graph[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == -1) {
                    graph[i][j] = 0;
                    continue;
                }
                
                if (i != 0) {
                    graph[i][j] += graph[i-1][j] % 1000000007;
                }
                
                if (j != 0) {
                    graph[i][j] += graph[i][j-1] % 1000000007;
                }
            }
        }
        return graph[n][m] % 1000000007;
    }
}