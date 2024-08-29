class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(n, computers, visited, i);
            count++;
        }
        
        return count;
    }
    
    void dfs(int n, int[][] computers, boolean[] visited, int curr) {
        visited[curr] = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[curr][i] == 1) {
                dfs(n, computers, visited, i);
            }
        }
    }
}