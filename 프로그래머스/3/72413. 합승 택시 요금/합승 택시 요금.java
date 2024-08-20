import java.util.*;

class Solution {
    class Edge implements Comparable<Edge> {
        int node;
        int cost;
        
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge next) {
            return Integer.compare(this.cost, next.cost);
        }
    }
    
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList());
        }
        
        for (int[] next : fares) {
            graph.get(next[0]).add(new Edge(next[1], next[2]));
            graph.get(next[1]).add(new Edge(next[0], next[2]));
        }
        
        int[] answerS = dijkstra(graph, s);
        int[] answerA = dijkstra(graph, a);
        int[] answerB = dijkstra(graph, b);
        
        for (int i = 1; i <= n; i++) {
            int tmp = answerS[i] + answerA[i] + answerB[i];
            answer = Math.min(answer, tmp);
        }
        return answer;
    }
    
    int[] dijkstra(Map<Integer, List<Edge>> graph, int start) {
        int n = graph.size();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        Queue<Edge> que = new PriorityQueue();
        que.add(new Edge(start, 0));
        distance[start] = 0;
        
        while(!que.isEmpty()) {
            Edge edge = que.remove();
            
            if (distance[edge.node] < edge.cost) continue;
            
            for (Edge next : graph.get(edge.node)) {
                int nextCost = distance[edge.node] + next.cost;
                if (distance[next.node] > nextCost) {
                    distance[next.node] = nextCost;
                    que.add(new Edge(next.node, nextCost));
                }
            }
        }
        return distance;
    }
}