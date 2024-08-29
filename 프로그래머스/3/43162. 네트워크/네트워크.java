class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(n, computers, visited, i);
            answer++;
        }
        
        return answer;
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