import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            int cnt1 = dfs(a, graph, n);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
            
            int cnt2 = n - cnt1;
            
            answer = Math.min(answer, Math.abs(cnt2 - cnt1));
        }
        return answer;
    }
    
    int dfs(int start, Map<Integer, List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        int count = 1;
        
        while(!que.isEmpty()) {
            int curr = que.poll();
            
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}