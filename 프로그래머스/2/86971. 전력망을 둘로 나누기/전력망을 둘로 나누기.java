import java.util.*;

class Solution {
    int answer;
    public int solution(int n, int[][] wires) {
        answer = n;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n);
        
        return answer;
    }
    
    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curr, int n) {
        int count = 1;
        visited[curr] = true;
        
        for (int next : graph.get(curr)) {
            if (!visited[next]) {
                count += dfs(graph, visited, next, n);
            }
        }
        
        answer = Math.min(answer, Math.abs(n - count * 2));
        
        return count;
    }
}